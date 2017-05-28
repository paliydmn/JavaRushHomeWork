package com.javarush.test.level04.lesson16.home04;

import java.io.*;

/* Меня зовут 'Вася'...
Ввести с клавиатуры строку name.
Ввести с клавиатуры дату рождения (три числа): y, m, d.
Вывести на экран текст:
«Меня зовут name
Я родился d.m.y»
Пример:
Меня зовут Вася
Я родился 15.2.1988
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String name = reader.readLine();
        String sY = reader.readLine();
        String sM = reader.readLine();
        String sD = reader.readLine();

        int myear = Integer.parseInt(sY);
        int mmonth = Integer.parseInt(sM);
        int mdate = Integer.parseInt(sD);

        System.out.println("Меня зовут " + name);
        System.out.print("Я родился " + mdate+"." + mmonth +"."+ myear);
        //напишите тут ваш код
    }
}
