package Demos;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Worker implements Runnable {

  private int id;
  private CountDownLatch countDownLatch;

  public Worker(int id, CountDownLatch countDownLatch) {
    this.id = id;
    this.countDownLatch = countDownLatch;
  }

  @Override
  public void run() {
    doWork();
    countDownLatch.countDown();
  }

  private void doWork() {
    try {
      System.out.println("Thread with id " + this.id + " start working!!");
      TimeUnit.MILLISECONDS.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

public class LatchDemo {

  public static void main(String[] args) throws InterruptedException {
    CountDownLatch countDownLatch = new CountDownLatch(5);
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    for (int x = 0; x < 5; x++) {
      executorService.execute(new Worker(x, countDownLatch));
    }
    countDownLatch.await();
    System.out.println("All tasks have been finished");
    executorService.shutdown();
  }
}
