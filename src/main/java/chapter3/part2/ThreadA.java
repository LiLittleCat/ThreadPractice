package chapter3.part2;

/**
 * @author LiLittleCat
 * @since 2019/12/19
 */
public class ThreadA extends Thread {
    private final Count count;
    public ThreadA(Count count){
        this.count = count;
    }
    @Override
    public void run(){
        count.add();
    }

}
