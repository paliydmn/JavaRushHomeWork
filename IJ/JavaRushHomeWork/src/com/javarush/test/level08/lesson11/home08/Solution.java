package com.javarush.test.level08.lesson11.home08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/* Пять наибольших чисел
Создать массив на 20 чисел. Заполнить его числами с клавиатуры. Вывести пять наибольших чисел.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++)
        {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);

        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println(array[2]);
        System.out.println(array[3]);
        System.out.println(array[4]);
    }

    public static void sort(int[] array)
    {
        //напишите тут ваш код
// slow way
       /* int[] result = new int[5];

        for (int a = 0; a < result.length; a ++)
        {
            int tmp = 0;
            for (int i = 0; i < array.length; i++)
            {
                if(tmp < array[i])
                   tmp = array[i];
            }
            result[a] = tmp;
            for (int i = 0; i < array.length; i++)
            {
                if(tmp == array[i])
                    array[i] = 0;
            }
        }
        for (int i = 0; i < 5; i++)
            array[i] = result[i];
*/
        // fast way
       Arrays.sort(array);
         ArrayList<Integer> arrList = new ArrayList<>();

        for (int i =0; i < array.length; i++)
                    arrList.add(array[i]);
        for (int i = 0; i < 5; i++)
            array[i] = arrList.get(arrList.size()-1-i);
    }
}
