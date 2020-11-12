package com.cmh.workstudy.Thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * *CountDownLatch和CyclicBarrier区别：
 * 1.countDownLatch是一个计数器，线程完成一个记录一个，计数器递减，只能只用一次
 * 2.CyclicBarrier的计数器更像一个阀门，需要所有线程都到达，然后继续执行，计数器递增，提供reset功能，可以多次使用
 *
 * 作者：指尖架构141319
 * 链接：https://www.jianshu.com/p/e233bb37d2e6
 * 来源：简书
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

//模拟并发情况下CountDownLatch的作用
public class Parallellimit {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        CountDownLatch cdl = new CountDownLatch(100);
        for (int i = 0; i < 100; i++) {
            CountRunnable runnable = new CountRunnable(cdl);
            pool.execute(runnable);
        }
    }
}

class CountRunnable implements Runnable {
    private CountDownLatch countDownLatch;
    public CountRunnable(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }
    @Override
    public void run() {
        try {
            synchronized (countDownLatch) {
                /*** 每次减少一个容量*/
                countDownLatch.countDown();
                System.out.println("thread counts = " + (countDownLatch.getCount()));
            }
            countDownLatch.await();
            System.out.println("concurrency counts = " + (100 - countDownLatch.getCount()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
