package four;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    private static final int NUM = 100;

    private ThreadPoolExecutor executor = new ThreadPoolExecutor(
            5, 5, 0, TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(200), new MyThreadFactory(),
            new ThreadPoolExecutor.CallerRunsPolicy());

    public static void main(String[] args) {
        ArrayList<File> files = new ArrayList<>(args.length);
        for (String fileName : args) {
            files.add(new File(fileName));
        }

        Main main = new Main();
        List<Node> frequency = main.frequency(files);
        for (int i = frequency.size() - 1; i >= 0; i--){
            Node cur = frequency.get(i);
            System.out.println("单词 " + cur.s + " 出现 " + cur.num + " 次");
        }
    }

    public List<Node> frequency(ArrayList<File> files){
        Deque<Future<String>> futureDeque = new ArrayDeque<>(files.size());
        for (File file : files) {
            futureDeque.offer(executor.submit(() -> calculate(file)));
        }

        HashMap<String, Integer> map = new HashMap<>();

        // 等待第一批任务执行完成
        while (!futureDeque.isEmpty()) {
            Future<String> future = futureDeque.pollFirst();
            File file = null;
            try {
                String fileName = future.get(10, TimeUnit.SECONDS);
                file = new File(fileName);
                try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    reader.lines().forEach(line -> {
                        String[] strings = line.split(" ");
                        Integer count = map.getOrDefault(strings[0], 0);
                        map.put(strings[0], count + Integer.valueOf(strings[1]));
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                // 超时放回队列
                futureDeque.offer(future);
            } finally {
                if (file != null){
                    file.delete();
                }
            }
        }

        //统计完词频
        PriorityQueue<Node> queue = new PriorityQueue<>(NUM, Comparator.comparingInt(a -> a.num));
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (queue.size() < NUM){
                queue.offer(new Node(entry.getKey(), entry.getValue()));
            } else {
                Node head = queue.peek();
                if (head.num < entry.getValue()){
                    queue.offer(new Node(entry.getKey(), entry.getValue()));
                }
            }
        }

        return new ArrayList<>(queue);
    }

    private String calculate(File file){
        HashMap<String, Integer> map = new HashMap<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            reader.lines().forEach(line -> {
                String[] strings = line.split(" ");
                for (String string : strings) {
                    Integer count = map.getOrDefault(string, 0);
                    map.put(string, count + 1);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        String newFileName = file.getName() + ".tmp";
        try (BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(new File(newFileName)))) {
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                bufferedWriter.write(entry.getKey() + " " + entry.getValue());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newFileName;
    }

    class Node{
        String s;
        Integer num;

        Node(String s, Integer num){
            this.s = s;
            this.num = num;
        }
    }

    class MyThreadFactory implements ThreadFactory{

        private static final String threadName = "frequency-thread-";
        private AtomicInteger atomicInteger = new AtomicInteger(1);

        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r, threadName + atomicInteger.getAndIncrement());
        }
    }
}
