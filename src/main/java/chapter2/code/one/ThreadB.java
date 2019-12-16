package chapter2.code.one;

/**
 * @author LiLittleCat
 * @since 2019/12/12
 */
public class ThreadB implements Runnable {
    public void run() {
        try {
            Thread.sleep(500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("这是线程B");
    }

}
