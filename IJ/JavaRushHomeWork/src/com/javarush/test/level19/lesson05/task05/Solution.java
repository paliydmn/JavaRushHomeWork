package com.javarush.test.level19.lesson05.task05;

/* Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Удалить все знаки пунктуации, включая символы новой строки. Результат вывести во второй файл.
http://ru.wikipedia.org/wiki/%D0%9F%D1%83%D0%BD%D0%BA%D1%82%D1%83%D0%B0%D1%86%D0%B8%D1%8F
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
            String tmp = scanner.nextLine().replaceAll("[^a-zA-Z]","");
            fileWriter.write(tmp);
        }
        scanner.close();
        fileReader.close();
        fileWriter.close();
    }
}
