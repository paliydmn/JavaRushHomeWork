package com.javarush.test.level07.lesson06.task05;
import java.lang.String;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Удали последнюю строку и вставь её в начало
1. Создай список строк.
2. Добавь в него 5 строчек с клавиатуры.
3. Удали последнюю строку и вставь её в начало. Повторить 13 раз.
4. Используя цикл выведи содержимое на экран, каждое значение с новой строки.
*/
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList list = new ArrayList<>();

        for (int i = 0; i < 5; i++)
        {
            list.add(reader.readLine());
        }
       /*
       System.out.println(list.get(list.size() - 1));
        list.remove(list.size() - 1);
        System.out.println(list.get(list.size() - 1));
       */
       // String tmp;
        Object tmp = list.get(1);

        for (int i = 0; i < 13; i++)
        {
             tmp = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            list.add(0, tmp);
        }
        for (int i = 0; i < list.size(); i++)
        {
            System.out.println(list.get(i));
        }
    }
}
