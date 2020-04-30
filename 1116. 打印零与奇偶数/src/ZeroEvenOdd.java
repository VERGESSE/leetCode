import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

class ZeroEvenOdd {
    private int n;
    private AtomicInteger index = new AtomicInteger(0);

    private Semaphore semaphore1 = new Semaphore(0);
    private Semaphore semaphore2 = new Semaphore(0);
    private Semaphore semaphore3 = new Semaphore(0);

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        while(index.get() < n){
            printNumber.accept(0);
            if(index.get()%2 == 1)
                semaphore2.release();
            else
                semaphore3.release();
            semaphore1.acquire();
        }
        semaphore2.release();
        semaphore3.release();
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        while(true){
            semaphore2.acquire();
            if(index.get() == n)
                break;
            printNumber.accept(index.incrementAndGet());

            semaphore1.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        while(true){
            semaphore3.acquire();
            if(index.get() == n)
                break;
            printNumber.accept(index.incrementAndGet());

            semaphore1.release();
        }
    }
}