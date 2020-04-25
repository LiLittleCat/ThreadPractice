package chapter2.code.part4;

/**
 * @author LiLittleCat
 * @since 2019/12/16
 */
public class ThreadMain {
    public static void main(String[] args) {
        Thread tA = new ThreadA();
        Thread tB = new ThreadB();
        tA.setDaemon(true);

        tB.start();
        tA.start();
        Thread mainThread = Thread.currentThread();
        System.out.println("线程A是不是守护线程" + tA.isDaemon());
        System.out.println("线程B是不是守护线程" + tB.isDaemon());
        System.out.println("线程Main是不是守护线程" + mainThread.isDaemon());
    }
}
