# 第三章 Thread安全

## 3.1 Java内存模型与多线程
* JMM(Java Memory Model)规定主内存（堆内存）和工作内存
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
- 使用java.util.concurrent下的类
- 使用锁机制，synchronized，lock方式
## 3.4 隐式锁，线程同步synchronized
默认锁的对象是当前对象本身，等同于synchronized(this){}，不需要加锁解锁操作