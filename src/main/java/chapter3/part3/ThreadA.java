package chapter3.part3;

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
