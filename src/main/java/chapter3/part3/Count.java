package chapter3.part3;

/**
 * @author LiLittleCat
 * @since 2019/12/19
 */
public class Count {
    public int num = 0;

    public synchronized void add() {
        try {
            Thread.sleep(5L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        num += 1;
        System.out.println(Thread.currentThread().getName() + "---" + num);
    }
}
