import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class Thread1 {
    private static long n = 0L;

    AtomicInteger count = new AtomicInteger(0);


    void m() {
        for (int i = 0; i < 10000; i++) {
            count.incrementAndGet();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[100];
        CountDownLatch latch = new CountDownLatch(threads.length);


        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {

                for (int j = 0; j < 10000; j++) {
                    n++;
                }

                latch.countDown();
            });
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }

        latch.await();

        System.out.println(n);
    }


}
