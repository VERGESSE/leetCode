import java.util.concurrent.Semaphore;

class FooBar {
    private int n;
    private Semaphore semaphore1 = new Semaphore(0);
    private Semaphore semaphore2 = new Semaphore(1);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            semaphore2.acquire();
        	// printFoo.run() outputs "foo". Do not change or remove this line.
        	printFoo.run();
            semaphore1.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            semaphore1.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
        	printBar.run();
            semaphore2.release();
        }
    }
}

/* volatile
class FooBar {
    private int n;
    private volatile boolean finish=false;
    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printFoo.run() outputs "foo". Do not change or remove this line.
            while(finish){
                Thread.yield();
            }
            printFoo.run();
            finish = true;
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printBar.run() outputs "bar". Do not change or remove this line.
            while (!finish){
                Thread.yield();
            }
            printBar.run();
            finish = false;
        }
    }
}
 */