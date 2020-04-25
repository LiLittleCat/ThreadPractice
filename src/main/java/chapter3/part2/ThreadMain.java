package chapter3.part2;

/**
 * @author LiLittleCat
 * @since 2019/12/19
 */
public class ThreadMain {
    public static void main(String[] args) {
        Count count = new Count();
        for (int i = 0; i < 5; i++) {
            ThreadA threadA = new ThreadA(count);
            threadA.start();
        }
        try {
            Thread.sleep(100L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //多线程不安全问题，每次打印的结果都不一样
        System.out.println("5个人干活，最后的值为：" + count.num);
    }
}
