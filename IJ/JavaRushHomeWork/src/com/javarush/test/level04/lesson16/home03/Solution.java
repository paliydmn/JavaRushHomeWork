package com.javarush.test.level04.lesson16.home03;

import java.io.*;

/* Посчитать сумму чисел
Вводить с клавиатуры числа и считать их сумму. Если пользователь ввел -1, вывести на экран сумму и завершить программу.  -1 должно учитываться в сумме.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int total = 0;
        boolean exit = true;
        while (exit)
        {
            String sNum = reader.readLine();
            int sum = Integer.parseInt(sNum);
            System.out.println("+");
            if (sum > 0)
            total = total + sum;
            else
            {
                total = total + sum;
                exit = false;
            }
        }
        System.out.println(total);
        //напишите тут ваш код
    }
}
