package chapter2.code.part1;

/**
 * @author LiLittleCat
 * @since 2019/12/12
 */
public class ThreadMainA {
    public static void main(String[] args) {
        ThreadA threadA = new ThreadA();
        //启动线程
        threadA.start();
        System.out.println("这是主线程： ");
    }
}
