package PhilosopherPloblem;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Chopstick {

  private final ReentrantLock lock;
  private final int id;

  public Chopstick(int id) {
    this.lock = new ReentrantLock();
    this.id = id;
  }

  public boolean pickUp(Philosopher philosopher, State state) {
    try {
      if (lock.tryLock(10, TimeUnit.MILLISECONDS)) {
        System.out.println(philosopher + " pick up " + state + " " + this);
        return true;
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return false;
  }

  public void putDown(Philosopher philosopher, State state) {
    this.lock.unlock();
    System.out.println(philosopher + " put down " + state + " " + this);
  }

  @Override
  public String toString() {
    return "Chopstick-" + id;
  }
}
