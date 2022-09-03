package leetcode;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class LeetCode1115 {

}

class FooBar {
    private int n;

    private CyclicBarrier cb = new CyclicBarrier(2);
    volatile boolean fooExec = true;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while (!fooExec) {
                //false的时候，bar线程在执行，foo线程在这此处空转
            }
            printFoo.run();//打印foo
            fooExec = false;//设置变量
            try {
                cb.await();//线程foo到达同步点
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            try {
                cb.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            printBar.run();
            fooExec = true;
        }
    }
}

// Semaphore实现
//class leetcode.FooBar {
//    private int n;
//
//    private Semaphore fooSema = new Semaphore(1);
//    private Semaphore barSema = new Semaphore(0);
//
//    public leetcode.FooBar(int n) {
//        this.n = n;
//    }
//
//    public void foo(Runnable printFoo) throws InterruptedException {
//        for (int i = 0; i < n; i++) {
//            fooSema.acquire();
//            // printFoo.run() outputs "foo". Do not change or remove this line.
//            printFoo.run();
//            barSema.release();
//        }
//
//    }
//
//    public void bar(Runnable printBar) throws InterruptedException {
//
//        for (int i = 0; i < n; i++) {
//            barSema.acquire();
//            // printBar.run() outputs "bar". Do not change or remove this line.
//            printBar.run();
//            fooSema.release();
//        }
//    }
//}