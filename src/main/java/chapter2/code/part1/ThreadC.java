package chapter2.code.part1;

import java.util.concurrent.Callable;

/**
 * @author LiLittleCat
 * @since 2019/12/12
 */
public class ThreadC implements Callable<String> {
    @Override
    public String call() throws Exception {
        try {
            Thread.sleep(500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("这是线程C");
        return "thread C";
    }
}
