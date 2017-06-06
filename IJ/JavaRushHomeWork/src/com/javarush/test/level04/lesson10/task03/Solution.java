package com.javarush.test.level04.lesson10.task03;

import java.io.*;

/* Хорошего не бывает много
Ввести с клавиатуры строку и число N.
Вывести на экран строку N раз используя цикл while.
Пример ввода:
абв
2
Пример вывода:
абв
абв
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = reader.readLine();
        String sCount = reader.readLine();
        int count = Integer.parseInt(sCount);
        int i = 1;
        while (i <= count)
        {
            System.out.println(text);
            i++;
        }

        //напишите тут ваш код

    }
}
