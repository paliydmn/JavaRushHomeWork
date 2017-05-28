package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inData = reader.readLine();//"D:\\data.txt";//
        reader.close();
        FileReader fileReader = new FileReader(inData);
        int counter = 0;
        Scanner scanner = new Scanner(new FileReader(inData));

        while (scanner.hasNext())
        {
            String[] tmp = scanner.next().replaceAll("[^a-zA-Z 0-9]", " ").split("\\s");
            for (String s : tmp)
            {
                if (s.equals("world"))
                    counter++;
            }
        }
        scanner.close();
        fileReader.close();
        System.out.println(counter);

    }
}
