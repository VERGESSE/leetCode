package common;

import sort.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SortChacker {

    public static void main(String[] args) throws InterruptedException {
        BubbleSort bubbleSort = new BubbleSort();
        CountSort countSort = new CountSort();
        InsertionSort insertionSort = new InsertionSort();
        MergeSort mergeSort = new MergeSort();
        QuickSort quickSort = new QuickSort();
        RadixSort radixSort = new RadixSort();
        SelectionSort selectionSort = new SelectionSort();
        ShellSort shellSort = new ShellSort();

        ExecutorService executor = Executors.newFixedThreadPool(8);
        executor.execute(new RunSort(bubbleSort));
        executor.execute(new RunSort(countSort));
        executor.execute(new RunSort(insertionSort));
        executor.execute(new RunSort(mergeSort));
        executor.execute(new RunSort(quickSort));
        executor.execute(new RunSort(radixSort));
        executor.execute(new RunSort(selectionSort));
        executor.execute(new RunSort(shellSort));

        executor.shutdown();
        while (!executor.isTerminated()){
            TimeUnit.SECONDS.sleep(1);
        }
    }
}

class RunSort implements Runnable{
    private static DataChecker dataChecker = new DataChecker();
    private Sorter sorter;

    RunSort(Sorter sorter){
        this.sorter = sorter;
    }

    @Override
    public void run() {
        long pre = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            sorter.sort(dataChecker.generateRandomArray());
        }
        long post = System.currentTimeMillis();

        System.out.println(sorter.getClass().getSimpleName() + ": " + (post - pre) / 10 + " ms");
    }
}
