package Demos;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class FixedThreadExecutor {

  public static void main(String[] args) {
    ExecutorService executorService = Executors.newFixedThreadPool(5);
    for (int i = 0; i <= 50; i++) {
      executorService.execute(() -> {
        try {
          TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
      });
    }
  }
}
