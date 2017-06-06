package com.javarush.test.level04.lesson10.task04;


import java.io.*;

/* S-квадрат
Вывести на экран квадрат из 10х10 букв S используя цикл while.
Буквы в каждой строке не разделять.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int i = 1;
       /* MyCounter count = new MyCounter();
        int thiscount = count.mycount;*/
         while (i <= 10)
        {


            MyCounter count = new MyCounter();
            int thiscount = count.mycount;

            while (thiscount <= 10)
            {

                System.out.print("S");
                thiscount++;
            }
            System.out.println("");
            i++;
        }


        //напишите тут ваш код

    }
     static class MyCounter
    {
        private static int mycount = 1;
    }
}
