package chapter3.part3;

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
        //add方法加入synchronized，每次结果都一样
        System.out.println("5个人干活，最后的值为：" + count.num);
    }
}
