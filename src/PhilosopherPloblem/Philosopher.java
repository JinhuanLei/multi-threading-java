package PhilosopherPloblem;

import java.util.Random;

public class Philosopher implements Runnable {

  private final Chopstick leftChopstick;
  private final Chopstick rightChopstick;
  private final int id;
  private volatile boolean isFull = false;
  private final Random random;
  private int eatingCounter;

  public Philosopher(Chopstick leftChopstick, Chopstick rightChopstick, int id) {
    this.leftChopstick = leftChopstick;
    this.rightChopstick = rightChopstick;
    this.id = id;
    this.random = new Random();
  }

  @Override
  public void run() {
    while (!isFull) {
      think();
      if (leftChopstick.pickUp(this, State.LEFT)) {
        if (rightChopstick.pickUp(this, State.RIGHT)) {
          eat();
          rightChopstick.putDown(this, State.RIGHT);
        }
        leftChopstick.putDown(this, State.LEFT);
      }
    }
  }

  private void eat() {
    System.out.println(this + " is eating!");
    this.eatingCounter++;
    try {
      Thread.sleep(this.random.nextInt(1000));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Override
  public String toString() {
    return "Philosopher-" + id;
  }

  private void think() {
    System.out.println(this + " is thinking...");
    try {
      Thread.sleep(this.random.nextInt(1000));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public void setFull(boolean isFull) {
    this.isFull = isFull;
  }

  public int getEatingCounter() {
    return eatingCounter;
  }
}
