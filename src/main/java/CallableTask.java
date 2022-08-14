import java.util.Random;
import java.util.concurrent.*;

public class CallableTask {


    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        FutureTask<Integer> task = new FutureTask<>(new CallableTest());
        task.run();
        Future<Integer> future = executorService.submit(new CallableTest());
        Future<?> test = executorService.submit(() -> System.out.println("test"));

        System.out.println(Thread.currentThread().getName());
        Thread.sleep(4000);
        boolean isCancel = future.cancel(false);
        System.out.println("next");
        System.out.println(isCancel);
        Integer integer = future.get();
        System.out.println(integer);

        if (executorService != null) {
            executorService.shutdown();
        }

    }
}

class CallableTest implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("callable do somothing");
        Thread.sleep(5000);
        return new Random().nextInt(100);
    }
}