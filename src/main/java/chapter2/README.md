# 第二章 认识Java里的Thread

## 2.1 线程简单实现的三种方法

 1. [继承Thread，重写run()方法](./code/one/ThreadA.java)
 
    缺点：只能单继承

 2. [实现Runable接口，实现run()方法](./code/one/ThreadB.java)
 
 3. [实现Callable接口，实现call()方法](./code/one/ThreadC.java)
 
## 2.2 Thread里的属性和方法

 * getPriority()和setPriority()存取线程的优先级
    ```java
    /**
     * The minimum priority that a thread can have.
     */
    public final static int MIN_PRIORITY = 1;

   /**
     * The default priority that is assigned to a thread.
     */
    public final static int NORM_PRIORITY = 5;

    /**
     * The maximum priority that a thread can have.
     */
    public final static int MAX_PRIORITY = 10;
    ```

## 2.3 线程的中断机制

* ~~Thread.stop()~~已过时
* Thread.interrupt(),中断不能直接终止另一个进程，需要被中断的进程自己处理中断
    * public static boolean interrupted(),测试当前线程是否已经中断，线程的中断状态由该方法清除。
      连续调用，第二次会返回false。
    * public boolean isInterrupted(),测试线程是否已经中断。线程的中断状态不受该方法影响。
    * public void interrupt(),中断进程，无返回结果。是唯一能将中断状态设置为true的方法