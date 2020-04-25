package chapter2.code.part8;

/**
 * @author LiLittleCat
 * @since 2019/12/19
 */
public class ThreadMain {
    public static void main(String[] args) {
        ThreadB threadB = new ThreadB();
        Thread thread = new Thread(threadB);
        thread.setUncaughtExceptionHandler(new ExceptionHandlerThreadB());
        thread.start();
    }
}
