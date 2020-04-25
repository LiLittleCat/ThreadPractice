package chapter2.code.part1;

/**
 * @author LiLittleCat
 * @since 2019/12/12
 */
public class ThreadA extends Thread {
    @Override
    public void run() {
        super.run();
        try {
            Thread.sleep(500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("这是线程A");
    }
}
