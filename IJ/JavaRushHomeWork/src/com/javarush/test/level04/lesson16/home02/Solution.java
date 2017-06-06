package com.javarush.test.level04.lesson16.home02;

import java.io.*;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sA = reader.readLine();
        String sB = reader.readLine();
        String sC = reader.readLine();

        int a = Integer.parseInt(sA);
        int b = Integer.parseInt(sB);
        int c = Integer.parseInt(sC);



        if (a < b && b < c || a > b && b > c )
            System.out.println(b);
        else if (a > b && a < c || a < b && a > c)
            System.out.println(a);
        else if (a > b && a > c && c > b)
            System.out.println(c);



       /* if (a < b && a < c && c < b)
            System.out.println(c);
        else
            System.out.println(b);
       // if (b < a && b < c && a < c)
        //    System.out.println(a);
*/


        //напишите тут ваш код
    }

    private static int minAB (int a, int b)
    {
        if (a > b)
            return b;
        return a;
    }
}
