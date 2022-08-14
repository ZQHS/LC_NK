import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {


    public static void main(String[] args) throws InterruptedException {


        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            int count = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.printf("thread_%d_start%n", count);
                }
            });
        }

        executorService.shutdown();

    }


}
