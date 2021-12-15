package StudentBookProblem;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class Starter {

    public static final int BOOK_COUNT = 3;
    public static final int STUDENT_COUNT = 5;

    public static void main(String[] args) {
        var books = new Book[BOOK_COUNT];
        var students = new Student[STUDENT_COUNT];
        var executorService = Executors.newFixedThreadPool(STUDENT_COUNT);
        for (int x = 0; x < BOOK_COUNT; x++) {
            books[x] = new Book(x, new ReentrantLock());
        }
        for (int x = 0; x < STUDENT_COUNT; x++) {
            students[x] = new Student(x, books, new Random());
        }
        for (Student student : students) {
            executorService.execute(student);
        }
    }
}
