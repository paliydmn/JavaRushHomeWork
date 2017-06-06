package com.dima.tests;

import java.util.Date;

/**
 * Created by Dima on 18.01.2016.
 */
public class DateTests
{
    public static void main(String[] args) throws Exception
    {

  /*      Date startTime = new Date();

        long endTime = startTime.getTime() + 5000;
        Date endDate = new Date(endTime);

        Thread.sleep(3000);

        Date currentTime = new Date();
        if (currentTime.after(endDate))
        {
            System.out.println("End time!");
        }*/

        Date currentTime = new Date();
        int hours = currentTime.getHours();
        int mins = currentTime.getMinutes();
        int secs = currentTime.getSeconds();

        System.out.println("Time from midnight " + hours + ":" + mins + ":" + secs);

    }
}
