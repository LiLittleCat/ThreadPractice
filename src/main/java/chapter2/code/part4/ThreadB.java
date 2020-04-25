package chapter2.code.part4;

/**
 * @author LiLittleCat
 * @since 2019/12/16
 */
public class ThreadB extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("线程B第" + i + "次执行！");
            try {
                Thread.sleep(7L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
