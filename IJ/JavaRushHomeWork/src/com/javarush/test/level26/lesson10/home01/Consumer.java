package com.javarush.test.level26.lesson10.home01;

import java.util.concurrent.BlockingQueue;

/**
 * Created by Dima on 23.09.2016.
 */
public class Consumer implements Runnable
{
    protected BlockingQueue queue;

    public Consumer(BlockingQueue queue)
    {
        this.queue = queue;
    }

    @Override
    public void run()
    {
        try{
        int i = 0;
        while (true) {
            System.out.println(queue.take());
            Thread.sleep(20);
        }
    } catch (InterruptedException e) {
    System.out.println(String.format("[%s] thread was terminated - my", Thread.currentThread().getName()));
}

    }
}
