package com.javarush.test.level10.lesson11.bonus02;

import java.io.*;
import java.util.HashMap;

/* Нужно добавить в программу новую функциональность
Задача: Программа вводит с клавиатуры пару (число и строку) и выводит их на экран.
Новая задача: Программа вводит с клавиатуры пары (число и строку), сохраняет их в HashMap.
Пустая строка – конец ввода данных. Числа могу повторяться. Строки всегда уникальны. Введенные данные не должны потеряться!
Затем программа выводит содержание HashMap на экран.

Пример ввода:
1
Мама
2
Рама
1
Мыла

Пример вывода:
1 Мыла
2 Рама
1 Мама
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String,Integer> map = new HashMap<String, Integer>();

        while (true)
        {
            //catch and break If the id = null
            int id = 0;
            try
            {
                id = Integer.parseInt(reader.readLine());
            }
            catch (NumberFormatException e)
            {
                break;
            }
            catch (IOException e)
            {
                break;
            }
            String name = reader.readLine();
            if (name.isEmpty())
            {
                break;
            }
            map.put(name,id);
        }
        // print the HashMap
         printMap(map);
    }

    public static void printMap(HashMap<String,Integer> map)
    {
        for (HashMap.Entry<String,Integer> pair : map.entrySet())
        {
            String name = pair.getKey();
            int id = pair.getValue();

            System.out.println(id + " " + name);
        }
    }
}
