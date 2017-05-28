package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String inData = reader.readLine();
        String outData = reader.readLine();
        reader.close();
        FileReader fileReader = new FileReader(inData);
        Scanner scanner = new Scanner(new FileReader(inData));
        FileWriter fileWriter = new FileWriter(outData);

        while (scanner.hasNext())
        {
               String tmp = scanner.next();
           try
           {
               int i = Integer.parseInt(tmp);
               fileWriter.write(tmp + " ");

           }
           catch (Exception e)
           {

           }

        }
        scanner.close();
        fileReader.close();
        fileWriter.close();

    }
}
