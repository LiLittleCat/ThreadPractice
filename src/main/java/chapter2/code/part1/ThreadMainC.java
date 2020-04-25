package chapter2.code.part1;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author LiLittleCat
 * @since 2019/12/12
 */
public class ThreadMainC {
    public static void main(String[] args) {
        ThreadC threadC = new ThreadC();
        FutureTask<String> future = new FutureTask<>(threadC);
        new Thread(future).start();
        System.out.println("这是主进程：begin");
        try {
            System.out.println("得到的返回结果是： " + future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("这是主进程：end");
    }
}
