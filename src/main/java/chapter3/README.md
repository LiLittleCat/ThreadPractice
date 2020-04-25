# 第三章 Thread安全

## 3.1 Java内存模型与多线程
* `JMM(Java Memory Model)`规定主内存（堆内存）和工作内存
* 线程操作对象的执行顺序：
    1. 从主存复制变量到当前工作内存
    2. 执行代码，改变共享变量值
    3. 用工作内存数据刷新主存相关内容
* 造成问题：
    1. 单个线程与线程的工作内存之间相互隔离，“可见性问题”
    2. 不同线程利用副本修改主存的顺序不同，“时序性问题”
    
## 3.2 线程不安全
多个线程同时操作一个数据结构时产生了相互修改和串行的情况，没有保证数据的一致性。
## 3.3 线程安全
实现线程安全的3种方法：
- 多实例，不用单例模式
- 使用`java.util.concurrent`下的类
- 使用锁机制，`synchronized`，`lock`方式
## 3.4 隐式锁，即线程同步`synchronized`
- 使用范围：
    - 方法声明
    - 代码块
    

默认锁的对象是当前对象本身，等同于synchronized(this){}，不需要加锁解锁操作  
其隐式规则如下：
- 当两个并发线程访问同一个object的synchronized(this)同步代码块时，一个时间内只能有一个线程得到执行，另一个必须等待当前线程执行完这个代码块之后才能指向该代码块。
- 当一个线程访问object的synchronized(this)同步代码块时，另一个线程仍可以访问该object的非synchronized(this)同步代码块。
- 当一个线程访问object的synchronized(this)同步代码块时，其他线程对该object中的其他synchronized(this)同步代码块的访问将被阻塞。
- 以上规则适用于其他对象锁  
  

锁的对象越小，执行效率越快。
## 3.5 显示锁`Lock`和`ReentrantLock`
Lock提供无条件的、可轮询的、定时的、可中断的锁获取操作，所有加锁解锁的方法都是显式的。  

核心方法：`lock()`,`unlock()`,`tryLock()`；  

实现类有：`ReentrantLock`,`ReentrantReadWriteLock.ReadLock`,`ReentrantReadWriteLock.WriteLock`  

对应的解说：

- `void lock()`：获取锁。如果锁不可用，出于线程调度的目的，将禁用当前线程，并且在获得锁之前，该线程将一直处于休眠状态。
- `void lockInterruptibly() throws InterruptedException`：如果当前线程未被中断，则获取锁。如果锁可用，则获取锁，并立即返回。如果锁不可用，出于线程调度的目的，将禁用当前线程并且在发生以下两种情况之一以前，该线程将一直处于休眠状态：锁由当前线程获得；或者其他某个线程中断当前线程，并且支持对锁获取的中断。如果当前线程：在进入此方法时已经设置了该线程的中断状态；或者在获取锁时被中断，并且支持对锁获取的中断，则将抛出`InteruptedException`，并清除当前线程的已中断状态。
- `boolean tryLock()`：仅在调用时锁为空闲状态才获取该锁。如果锁可用，则获取锁，并立即返回值true。如果锁不可用，则此方法将立即返回值false。通常对于那些不是必须获取锁的操作可能有用。
- `boolean tryLock（long ParamLong，TimeUnit Param TimeUnit）throws InterruptedException`：如果锁在给定的等待时间内空闲，并且当前线程未被中断，则获取锁。如果锁可用，则此方法将立即
  返回值true。如果锁不可用，出于线程调度目的，将禁用当前线程，并且在发生以下三种情况的任一种之前，该线程将一直处于休眠状态.
- `void unlock()`：释放锁。对应于`lock()`、`tryLock()`、`tryLock(xx)`、`lockInterruptibly()`等操作，如果成功的话应该对应着一个`unlock()`，这样可以避免死锁或者资源浪费。
- `new Condition()`：返回用来与此Lock实例一起使用的Condition实例。  



`ReentrantLock`是`Lock`的实现类，是一个互斥的同步器，它具有扩展的能力。在竞争条件下，`ReentrantLock`的实现要比现在的`synchronized`实现更具有可伸缩性。（有可能在`JVM`的将来版本中改进`synchronized`的竞争性能）这意味着当许多线程都竞争相同锁定时，使用`ReentrantLock`的吞吐量通常要比`synchronized`好。换句话说，当许多线程试图访问`ReentrantLock`保护的共享资源时，`JVM`将花费较少的时间来调度线程，而用更多个时间执行线程。虽然`ReentrantLock`类有许多优点，但是与同步相比，它有一个主要缺点：它可能忘记释放锁定。`ReentrantLock`是在工作中对方法块加锁使用频率最高的。

使用方法如下：

```java
class X {
    private final ReentrantLock lock = new ReentrantLock();

    //...
    public void m() {
        lock.lock();//获得锁
        try {
            // ... 方法体
        } finally {
            lock.unlock();//解锁
        }
    }
}
```



Lock与synchronized的比较：

1. Lock使用起来比较灵活，但是必须有释放锁的动作配合。
2. Lock必须手动释放和开启锁，而synchronized不需要手动释放和开启锁。
3. Lock只适用与代码块锁，而synchronized对象之间是互斥关系。





