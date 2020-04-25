package chapter3.part5;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author LiLittleCat
 * @since 2020/4/25
 */
public class ReentrantLockDemo {
    public static void main(String[] args) {
        final Count ct = new Count();
        for (int i = 0; i < 2; i++) {
            new Thread() {
                @Override
                public void run() {
                    ct.get();
                }
            }.start();
        }
        for (int i = 0; i < 2; i++) {
            new Thread() {
                @Override
                public void run() {
                    ct.put();
                }
            }.start();
        }
    }

    static class Count {
        //全局变量，每次执行结果相同
        final ReentrantLock lock = new ReentrantLock();
        public void get() {
            //局部变量，每次执行结果不同
//            final ReentrantLock lock = new ReentrantLock();
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + " get begin");
                Thread.sleep(1000L);
                System.out.println(Thread.currentThread().getName() + " get end");
                lock.unlock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        public void put() {
            final ReentrantLock lock = new ReentrantLock();
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + " put begin");
                Thread.sleep(1000L);
                System.out.println(Thread.currentThread().getName() + " put end");
                lock.unlock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
