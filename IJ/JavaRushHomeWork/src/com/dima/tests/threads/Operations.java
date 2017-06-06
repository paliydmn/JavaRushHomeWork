package com.dima.tests.threads;

/**
 * Created by Dima on 19.08.2016.
 */
public class Operations
{
    public static void main(String[] args)
    {
        final  Account a = new Account(1000);
        final Account b = new Account(2000);

        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    a.transfer(a,b, 500);
 //                   System.out.println("successful!");
                    System.out.println("acc1 = " + a.getBalance());
                    System.out.println("acc2 = " + b.getBalance());

                    b.transfer(b,a, 300);
                 /*   System.out.println("acc1 = " + a.getBalance());
                    System.out.println("acc2 = " + b.getBalance());

                    transfer(b,a, 300);
                    System.out.println("acc1 = " + a.getBalance());
                    System.out.println("acc2 = " + b.getBalance());

                    transfer(a,b, 300);
                    System.out.println("acc1 = " + a.getBalance());
                    System.out.println("acc2 = " + b.getBalance());

*/
                }
                catch (InsufficientFundsException e)
                {
                    e.printStackTrace();
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }).start();
    }


}
