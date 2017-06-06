package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        String file1 = args[0];
        String file2 = args[1];

        Scanner scanner = new Scanner(new FileReader(file1));
        FileWriter fileWriter = new FileWriter(file2);
        StringBuilder stringBuilder = new StringBuilder();

        while (scanner.hasNext())
        {
            String line = scanner.next();
        if(line.length() > 6)
            stringBuilder.append(line + " ");
        }
        String forWrite = stringBuilder.toString().trim().replaceAll(" ", ",");
        fileWriter.write(forWrite);
        scanner.close();
        fileWriter.close();

    }
}
