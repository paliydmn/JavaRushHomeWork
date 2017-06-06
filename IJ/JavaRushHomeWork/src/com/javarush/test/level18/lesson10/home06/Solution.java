package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {

        int[] ascii = new int[256];
        FileInputStream inputStream = new FileInputStream(args[0]);
        for (int i = 0; i < ascii.length; i++)
        {
            int counter = 0;
            while (inputStream.available() > 0)
            {
                if(inputStream.read() == ascii[i])
                    counter++;

                System.out.println(" test = " + counter);
            }

        }

      /*
       //worked code #1
       Map<Character, Integer> map = new HashMap<Character, Integer>();
        char[] alpha = new char[16901];
        int k = 0;
        for(int i = 0; i < 300; i++){
            alpha[i] = (char)(0 + (k++));
        }
        FileInputStream inputStream = new FileInputStream(args[0]);
        char[] charsFromInput = new char[inputStream.available()];
        int chCoutber = 0;
        while (inputStream.available() > 0)
        {
            charsFromInput[chCoutber] = (char)inputStream.read();
            chCoutber++;
        }
        inputStream.close();

        for (int s = 0; s < alpha.length; s++ )
        {
            int counter = 0;
            char tmp = alpha[s];
            for (int i = 0; i < charsFromInput.length; i++)
            {
                if (tmp == charsFromInput[i])
                {
                    counter++;
                    map.put(tmp, counter);
                }
            }
        }
        Map<Character, Integer> newMap = new TreeMap<Character, Integer>(map);
        for (Map.Entry<Character, Integer> result : newMap.entrySet())
        {
            System.out.println(result.getKey() + " " + result.getValue());
        }*/
    }
}
