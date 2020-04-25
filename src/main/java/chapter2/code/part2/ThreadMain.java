package chapter2.code.part2;

/**
 * @author LiLittleCat
 * @since 2019/12/16
 */
public class ThreadMain {
    public static void main(String[] args) {
        ThreadB threadB = new ThreadB();
        for (int i = 0; i < 5; i++) {
            new Thread(threadB, "线程名称：（" + i + ")").start();
        }
        //返回对当前正在执行的线程对象的引用
        Thread threadMain = Thread.currentThread();
        System.out.println("这是主线程");
        System.out.println("返回当前线程组中活跃线程个数： " + Thread.activeCount());
        System.out.println("这是主线程的名称" + threadMain.getName());
        System.out.println("返回该线程的标识符: " + threadMain.getId());
        System.out.println("返回该线程的优先级: " + threadMain.getPriority());
        System.out.println("返回该线程的状态: " + threadMain.getState());
        System.out.println("返回该线程所属的线程组: " + threadMain.getThreadGroup());
        System.out.println("返回该线程是否处于活动状态: " + threadMain.isAlive());
        System.out.println("返回该线程是否是守护线程: " + threadMain.isDaemon());
        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
