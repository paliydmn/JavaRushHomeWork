package com.javarush.test.level09.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/* Задача по алгоритмам
Задача: Пользователь вводит с клавиатуры список слов (и чисел). Слова вывести в возрастающем порядке, числа - в убывающем.
Пример ввода:
Вишня
1
Боб
3
Яблоко
2
0
Арбуз
Пример вывода:
Арбуз
3
Боб
2
Вишня
1
0
Яблоко
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true)
        {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array)
        {
            System.out.println(x);
        }
    }
    public static void sort(String[] array)
    {
        //Напишите тут ваш код
        //Собираем поцизции чисел в лист
        ArrayList<Integer> numberPositions = new ArrayList<Integer>();
        for (int i = 0; i < array.length; i++)
        {
            if (isNumber(array[i]))
            {
                numberPositions.add(i);
            }
        }
        //сортируем числа
        String a, b;
        for (int i = 0; i < numberPositions.size(); i++)
        {
            a = array[numberPositions.get(i)];
            for (int j = numberPositions.size() - 1; j > i; j--)
            {
                b = array[numberPositions.get(j)];
//                System.out.println("BEFORE CHANGE: array["+i+"] = "+ array[i] + " | array["+j+"] = "+ array[j]);
                if (Integer.parseInt(a) < Integer.parseInt(b))
                {
                    array[numberPositions.get(j)] = a;
                    array[numberPositions.get(i)] = b;
                    a = b;
                }
//                System.out.println("After CHANGE: array["+i+"] = "+ array[i] + " | array["+j+"] = "+ array[j]);
            }
        }
        //сортируем слова
        a = "";
        b = "";
        for (int i = 0; i < array.length; i++)
        {
            //если индекс не совпадает с индексом числа (то есть слова или всё остальное)
            if (!numberPositions.contains(i))
            {
                a = array[i];
                for (int j = array.length - 1; j > i; j--)
                {
                    if (!numberPositions.contains(j))
                    {
                        b = array[j];
                        if (isGreaterThan(a, b))
                        {
                            array[j] = a;
                            array[i] = b;
                            a = b;
                        }
                    }
                }
            }
        }
    }
   /* public static void sort(String[] array)
    {
        //напишите тут ваш код

       ArrayList<String> nums = new ArrayList<String>();
       ArrayList<String> words = new ArrayList<String>();
        for (int i = 0; i < array.length; i++)
        {
            if (isNumber(array[i]))
            {

                nums.add(array[i]);
            }
            else
            {
                words.add(array[i]);
            }
        }
        String[] arrNums = new String[nums.size()];
        String[] arrWords = new String[words.size()];

        for (int i = 0; i < words.size(); i++)
        {
            arrWords[i] = words.get(i);
        }
        Arrays.sort(arrWords);
        for (int i = 0; i < nums.size(); i++)
        {
            arrNums[i] = nums.get(i);
        }
        Arrays.sort(arrNums);


        for (int i = 0; i < arrWords.length; i++)
        {
            array[i] = arrWords[i];
        }
        int b = 0;
       // System.out.println(words.size());
       // System.out.println(array.length);
        for (int i = arrWords.length; i < array.length; i++)
        {
            array[arrWords.length + b] = arrNums[b];
            b++;
        }
    }*/

    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b)
    {
        return a.compareTo(b) > 0;
    }


    //строка - это на самом деле число?
    public static boolean isNumber(String s)
    {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++)
        {
            char c = chars[i];
            if ((i != 0 && c == '-') //есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-') ) // не цифра и не начинается с '-'
            {
                return false;
            }
        }
        return true;
    }
}
