package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileNotFoundException;
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

        while (scanner.hasNext())
        {
            String line = scanner.next();
            for (Character ch : line.toCharArray())
            {
                if(Character.isDigit(ch)){
                    fileWriter.write(line +" ");
                    break;
                }
            }
        }
        scanner.close();
        fileWriter.close();

    }
}
