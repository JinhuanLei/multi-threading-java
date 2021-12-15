package Demos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThreadsRunner {

  public static void main(String[] args) throws InterruptedException {
//    List<Integer> list = new ArrayList<>();
    List<Integer> list = Collections.synchronizedList(new ArrayList<>());
    Thread thread1 = new Thread(() -> {
      for (int x = 0; x < 10000000; x++) {
        list.add(x);
      }

    });
    Thread thread2 = new Thread(() -> {
      for (int x = 0; x < 10000000; x++) {
        list.add(x);
      }

    });
    thread1.start();
    thread2.start();
    thread1.join();
    thread2.join();

    System.out.println(list.size());
  }
}
