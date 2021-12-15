package StudentBookProblem;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Book {

    private int id;
    private Lock lock;


    public void read(Student student) throws InterruptedException {
        if (lock.tryLock(10, TimeUnit.MILLISECONDS)) {
            System.out.println(student + " start reading " + this);
            Thread.sleep(3000);
            lock.unlock();
            System.out.println(student + " finish reading " + this);
        }
    }

    @Override
    public String toString() {
        return "Book " + id;
    }

}
