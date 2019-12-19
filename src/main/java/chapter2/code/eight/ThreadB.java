package chapter2.code.eight;

/**
 * @author LiLittleCat
 * @since 2019/12/19
 */
public class ThreadB implements Runnable {
    public void run() {
        //构建一个Unchecked Exception
        int num = Integer.parseInt("TTT");
    }
}
