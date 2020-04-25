package chapter2.code.part1;

/**
 * @author LiLittleCat
 * @since 2019/12/12
 */
public class ThreadMainB {
    public static void main(String[] args) {
        ThreadB threadB = new ThreadB();
        //启动方式不同
        new Thread(threadB).start();
        System.out.println("这是主线程： ");
    }
}
