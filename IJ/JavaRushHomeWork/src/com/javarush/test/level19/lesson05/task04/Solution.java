package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
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
            String tmp = scanner.nextLine().replaceAll("[.]","!");
            fileWriter.write(tmp + "\n");
        }
        scanner.close();
        fileReader.close();
        fileWriter.close();

    }
}
