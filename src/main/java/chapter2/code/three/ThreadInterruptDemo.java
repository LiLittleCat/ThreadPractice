package chapter2.code.three;

/**
 * @author LiLittleCat
 * @since 2019/12/16
 */
public class ThreadInterruptDemo implements Runnable {
    public static void main(String[] args) throws Exception {
        Thread thread = new Thread(new ThreadInterruptDemo(), "InterruptDemo Thread");
        System.out.println("Starting thread...");
        thread.start();
        Thread.sleep(3000L);
        System.out.println("Interrupting thread...");
        thread.interrupt();
        System.out.println("是否中断" + thread.isInterrupted());
        Thread.sleep(3000L);
        System.out.printf("Stopping application...");
    }

    public void run() {
        boolean stop = false;
        while (!stop) {
            System.out.println("My Thread is running...");
            long time = System.currentTimeMillis();
            while ((System.currentTimeMillis() - time < 1000)) {
                //让循环持续一段时间
            }
            if(Thread.currentThread().isInterrupted()){
                Thread.currentThread();
                break;
            }
        }
        System.out.println("My Thread exiting under request...");
    }
}
