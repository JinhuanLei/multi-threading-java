package StudentBookProblem;

import java.util.Random;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Student implements Runnable {

    private int id;
    private Book[] books;
    private Random random;

    @Override
    public void run() {
        while (true) {
//            int index = random.nextInt(BOOK_COUNT);
//            try {
//                books[index].read(this);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            for (Book book : books) {
                try {
                    book.read(this);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Student " + id;
    }
}
