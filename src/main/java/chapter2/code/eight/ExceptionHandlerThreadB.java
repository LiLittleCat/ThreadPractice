package chapter2.code.eight;

/**
 * @author LiLittleCat
 * @since 2019/12/19
 */
public class ExceptionHandlerThreadB implements Thread.UncaughtExceptionHandler {
    //实现UncaughtExceptionHandler接口，处理Unchecked Exception
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("There is an exception\n");
        System.out.println("Thread: " + t.getId());
        System.out.println("Exception: " + e.getClass().getName() + ": " + e.getMessage());
        System.out.println("Stack Trace: \n");
        e.printStackTrace();
        System.out.println("Thread status: " + t.getState());
    }
}
