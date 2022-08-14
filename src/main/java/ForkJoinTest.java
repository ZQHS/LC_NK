import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class ForkJoinTest {
    private static int MAX = 100;
    private static int[] inits = new int[MAX];

    static {
        Random random = new Random();
        for (int i = 0; i < MAX; i++) {
            inits[i] = random.nextInt(1000);
        }
    }

    static class MyTask extends RecursiveTask<int[]> {

        private int[] source;

        public MyTask(int[] source) {
            this.source = source;
        }

        @Override
        protected int[] compute() {
            int sourceLength = source.length;
            if (sourceLength > 2) {
                int midIndex = sourceLength / 2;
                MyTask task1 = new MyTask(Arrays.copyOf(source, midIndex));
                task1.fork();
                MyTask task2 = new MyTask(Arrays.copyOfRange(source, midIndex, sourceLength));
                task2.fork();
                int[] res1 = task1.join();
                int[] res2 = task2.join();
                return joinInts(res1, res2);
            } else {
                if (sourceLength == 1 || source[0] <= source[1]) {
                    return source;
                } else {
                    int[] targetp = new int[sourceLength];
                    targetp[0] = source[1];
                    targetp[1] = source[0];
                    return targetp;
                }
            }
        }
    }

    private static int[] joinInts(int array1[], int array2[]) {
        int[] destInts = new int[array1.length + array2.length];
        int array1Len = array1.length;
        int array2Len = array2.length;
        int destLen = destInts.length;

        // 只需要以新的集合destInts的长度为标准，遍历一次即可
        for (int index = 0, array1Index = 0, array2Index = 0; index < destLen; index++) {
            int value1 = array1Index >= array1Len ? Integer.MAX_VALUE : array1[array1Index];
            int value2 = array2Index >= array2Len ? Integer.MAX_VALUE : array2[array2Index];
            // 如果条件成立，说明应该取数组array1中的值
            if (value1 < value2) {
                array1Index++;
                destInts[index] = value1;
            }
            // 否则取数组array2中的值
            else {
                array2Index++;
                destInts[index] = value2;
            }
        }

        return destInts;
    }


    public static void main(String[] args) {
        long beginTime = System.currentTimeMillis();
        ForkJoinPool pool = new ForkJoinPool();
        MyTask myTask = new MyTask(inits);
        ForkJoinTask<int[]> res = pool.submit(myTask);
        try {
            int[] ints = res.get();
            System.out.println(Arrays.toString(ints));
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("耗时=" + (endTime - beginTime));
    }
}
