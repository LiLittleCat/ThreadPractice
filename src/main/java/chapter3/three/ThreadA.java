package chapter3.three;

/**
 * @author LiLittleCat
 * @since 2019/12/19
 */
public class ThreadA extends Thread {
    private Count count;
    public ThreadA(Count count){
        this.count = count;
    }
    @Override
    public void run(){
        count.add();
    }

}