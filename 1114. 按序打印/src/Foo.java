import java.util.concurrent.CountDownLatch;

class Foo {

    CountDownLatch cd1 = new CountDownLatch(1);
    CountDownLatch cd2 = new CountDownLatch(1);

    public Foo() {
        
    }

    public void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        cd1.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        cd1.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        cd2.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        cd2.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}

/*  原子变量
class Foo {

  private AtomicInteger firstJobDone = new AtomicInteger(0);
  private AtomicInteger secondJobDone = new AtomicInteger(0);

  public Foo() {}

  public void first(Runnable printFirst) throws InterruptedException {
    // printFirst.run() outputs "first".
    printFirst.run();
    // mark the first job as done, by increasing its count.
    firstJobDone.incrementAndGet();
  }

  public void second(Runnable printSecond) throws InterruptedException {
    while (firstJobDone.get() != 1) {
      // waiting for the first job to be done.
    }
    // printSecond.run() outputs "second".
    printSecond.run();
    // mark the second as done, by increasing its count.
    secondJobDone.incrementAndGet();
  }

  public void third(Runnable printThird) throws InterruptedException {
    while (secondJobDone.get() != 1) {
      // waiting for the second job to be done.
    }
    // printThird.run() outputs "third".
    printThird.run();
  }
}
 */