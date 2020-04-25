package chapter2.code.part4;

/**
 * @author LiLittleCat
 * @since 2019/12/16
 */
public class ThreadA extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 9999999L; i++) {
            System.out.println("后台线程A第" + i + "次执行！");
            try {
                Thread.sleep(7L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
