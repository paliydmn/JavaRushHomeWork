package com.javarush.test.level10.lesson11.home04;

/* Большая зарплата
Вывести на экран надпись «Я не хочу изучать Java, я хочу большую зарплату» 40 раз по образцу.
Образец:
Я не хочу изучать Java, я хочу большую зарплату
 не хочу изучать Java, я хочу большую зарплату
не хочу изучать Java, я хочу большую зарплату
е хочу изучать Java, я хочу большую зарплату
 хочу изучать Java, я хочу большую зарплату
хочу изучать Java, я хочу большую зарплату
…
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        String s = "Я не хочу изучать Java, я хочу большую зарплату";

        //напишите тут ваш код

        ArrayList<Character> a = new ArrayList<Character>();
        for (int i = 0; i < s.length(); i++)
        {
            a.add(s.charAt(i));
        }
        int d = 0;
            for (int i = 0; i < 40; i++)
        {
            for (int r = 0; r < s.length() -i; r++)
            {
                System.out.print(a.get(r));
            }
            System.out.println("");
            a.remove(0);



        }
    }

}
