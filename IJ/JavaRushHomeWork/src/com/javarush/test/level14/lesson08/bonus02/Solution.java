package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int first = 0;
        first = Integer.parseInt(reader.readLine());
        int second = 0;
        second = Integer.parseInt(reader.readLine());

        int i = first;

        int s = second;
        while (true)
        {
            if(i % second == 0 && s % second == 0 )
            {
                System.out.println(second);
                break;
            }else
                second--;
        }

    }
}
