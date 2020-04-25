package chapter2.code.part8;

/**
 * @author LiLittleCat
 * @since 2019/12/19
 */
public class ThreadB implements Runnable {
    @Override
    public void run() {
        //构建一个Unchecked Exception
        int num = Integer.parseInt("TTT");
    }
}
