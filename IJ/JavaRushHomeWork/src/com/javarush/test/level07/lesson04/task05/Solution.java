package com.javarush.test.level07.lesson04.task05;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Один большой массив и два маленьких
1. Создать массив на 20 чисел.
2. Ввести в него значения с клавиатуры.
3. Создать два массива на 10 чисел каждый.
4. Скопировать большой массив в два маленьких: половину чисел в первый маленький, вторую половину во второй маленький.
5. Вывести второй маленький массив на экран, каждое значение выводить с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] bigIntArr = new int[20];
        int[] smallIntArr1 = new int[10];
        int[] smallIntArr2 = new int[10];

        for (int i = 0; i < bigIntArr.length; i++)
        {
            bigIntArr[i] = Integer.parseInt(reader.readLine());
        }
        for (int i = 0; i < smallIntArr1.length; i++)
        {
            smallIntArr1[i] = bigIntArr[i];
        }
        int tmp = 10;
        for (int i = 0; i < smallIntArr2.length; i++)
        {
            smallIntArr2[i] = bigIntArr[tmp];
            tmp++;
            System.out.println(smallIntArr2[i]);
        }


        //напишите тут ваш код

    }
}
