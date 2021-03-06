package com.javarush.test.level27.lesson04.task02;

/* Второй вариант дедлока
В методе secondMethod в синхронизированных блоках расставьте локи так,
чтобы при использовании класса Solution нитями образовывался дедлок
*/
public class Solution implements Runnable{
    private final Object lock = new Object();

    public synchronized void firstMethod() {
        synchronized (lock) {
            doSomething();
        }
    }

    public  void secondMethod() {
        synchronized (lock){
            synchronized (this){

                doSomething();
            }
        }
    }

    private void doSomething() {
        System.out.println("Something was done!");
    }

    public static void main(String[] args)
    {
        Solution solution = new Solution();
        Thread s;


        while (true)
        {
            s = new Thread(solution);
            s.start();
           /* new Thread(new Runnable()
            {
                @Override
                public void run()
                {
                    Solution solution = new Solution();
                    solution.firstMethod();
                    System.out.println(Thread.currentThread().getName());
                }
            }).start();
            new Thread(new Runnable()
            {
                @Override
                public void run()
                {
                    Solution solution = new Solution();
                    solution.secondMethod();
                    System.out.println(Thread.currentThread().getName());
                }
            }).start();*/
        }
    }


    @Override
    public void run()
    {
        this.firstMethod();
        this.secondMethod();
        System.out.println(Thread.currentThread().getName());
    }
}