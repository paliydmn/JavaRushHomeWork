package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());

        List<Integer> list = new ArrayList<Integer>();
        while (fileInputStream.available() > 0)
        {
            list.add(fileInputStream.read());
        }
        fileInputStream.close();

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int tmp : list)
        {
            int counter = 0;
            for (int i = 0; i < list.size(); i++)
            {
                if (tmp == list.get(i))
                    counter++;
            }
            map.put(tmp, counter);
           // System.out.println(tmp +"  key   -   val  "+ counter);
        }

        int minVal = 100000000;
        for (Map.Entry<Integer, Integer> pair : map.entrySet())
        {
            int tmp = pair.getValue();
            if (minVal > tmp)
                minVal = tmp;

        }
        for (Map.Entry<Integer, Integer> pair : map.entrySet())
        {
            if (minVal == pair.getValue())
            {
               /* while ((maxVal--) > 0)
                {*/
                System.out.println(pair.getKey());

            }
        }
    }
}
