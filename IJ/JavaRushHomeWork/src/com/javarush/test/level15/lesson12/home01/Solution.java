package com.javarush.test.level15.lesson12.home01;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Разные методы для разных типов
1. Считать с консоли данные, пока не введено слово "exit".
2. Для каждого значения, кроме "exit", вызвать метод print. Если значение:
2.1. содержит точку '.', то вызвать метод print для Double;
2.2. больше нуля, но меньше 128, то вызвать метод print для short;
2.3. больше либо равно 128, то вызвать метод print для Integer;
2.4. иначе, вызвать метод print для String.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //List<String> objects = new ArrayList<String>();

        while (true)
        {
            String tmp = reader.readLine();
            if (tmp.equals("exit"))
            {
                break;
            }
            else
            {
                try
                {
                    if (tmp.contains("."))
                    {
                        Double tmp2 = Double.parseDouble(tmp) ;
                        print(tmp2);
                    }
                    else if (Integer.parseInt(tmp)  > 0 && Integer.parseInt(tmp)  < 128)
                    {
                        short tmp2 = Short.parseShort(tmp);
                        print(tmp2);
                    }
                    else if (Integer.parseInt(tmp) >= 128)
                    {
                        Integer tmp2 = Integer.parseInt(tmp);
                        print(tmp2);
                    }
                }
                catch (Exception e)
                {
                    print(tmp);
                }
            }
        }

    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}

  /*      for (String tmp : objects)
        {

            try
            {
                if (tmp.contains("."))
                {
                    Double tmp2;
                    tmp2 = Double.parseDouble(tmp) ;
                    print(tmp2);
                }
                else if (Short.parseShort((String) tmp) > 0 && Short.parseShort((String) tmp) < 128)
                {
                    Short tmp2;
                    tmp2 = Short.parseShort((String) tmp);
                    print(tmp2);
                }
                else if (Integer.parseInt((String)tmp) >= 128)
                {
                    Integer tmp2;
                    tmp2 = Integer.parseInt((String)tmp);
                    print(tmp2);
                }
            }
            catch (Exception e)
            {
                print(tmp);
            }
        }*/