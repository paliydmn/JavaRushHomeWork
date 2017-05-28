package com.javarush.test.level18.lesson03.task05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;




/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());

        List<Integer> list = new ArrayList<Integer>();
        while (fileInputStream.available() > 0)
        {
            list.add(fileInputStream.read());
        }
        fileInputStream.close();

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int bytes : list)
        {
            int counter = 0;
            for (int i = 0; i < list.size(); i++)
            {
                if (bytes == list.get(i))
                    counter++;
            }
            map.put(bytes,counter);
            //System.out.println(bytes +" = key   -   val = "+ counter);
        }
        list.clear();
        for (Map.Entry<Integer, Integer> pair : map.entrySet())
        {
            list.add(pair.getKey());
        }
        Collections.sort(list);
        for (int bytes : list)
        {

            System.out.print(bytes + " ");
        }

    }
}

