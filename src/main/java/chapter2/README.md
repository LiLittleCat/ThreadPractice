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
* 需要注意，被终止的线程一定要对isInterrupted状态进行处理，否则代码是死循环的情况下，线程永远不会结束。

## 2.4 线程的生命周期
new,runnable,running,blocked,dead
1. 新建（new Thread）:创建Thread类的实例时进入此状态，但线程并没有运行（not alive）
2. 就绪（runnable）：线程已经启动，等待分配给CPU时间片，调用线程实例的start()方法进入此状态。  
   处于线程就绪队列，具备运行条件，此时线程活着（alive）
3. 运行（running）：线程获得CPU资源正在执行任务（run()方法），此时除非线程自动放弃CPU资源或者有更高优先级线程进入，  
   线程将一直运行至结束，此时线程活着（alive）
4. 堵塞（blocked）：由于某种原因导致正在运行的线程让出CPU资源并暂停执行，进入此状态
    * 正在睡眠：sleep(long t)
    * 正在等待：调用wait()方法，可用notify()方法回到就绪状态
    * 被另一个线程阻塞：调用suspend()方法，可用resume()方法恢复
    处于堵塞状态的线程是活着的（alive）
5. 死亡（dead）：线程执行完毕或被其他线程杀死，不可能再次进入就绪状态
    * 自然终止：正常运行run()方法结束
    * 异常终止： 调用stop()方法
    处于死亡状态的线程不是活着的（not alive）
    
## 2.5 守护线程
* 后台线程，进程结束，守护线程自动结束
* 线程**启动**前调用setDaemon(true)可设置守护线程
* 注意：
    * 所有前台线程执行完毕，JRE判断程序执行结束，不管后台线程
    * 程序结束时，守护线程有可能未退出
    
## 2.6 线程组
* 为了方便线程管理，根线程组是system线程组，system线程组下是main线程组

## 2.7 当前线程副本：ThreadLocal
* 使用ThreadLocal维护变量时，ThreadLocal为每一个使用该变量的线程提供独立的变量副本
