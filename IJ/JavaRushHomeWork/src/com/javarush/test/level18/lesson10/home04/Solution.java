package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {


        String file1 = "D:\\result.txt";
        String file2 = "D:\\result2.txt";
        FileInputStream inputStream = new FileInputStream(file1);
       // FileWriter fileWriter = new FileWriter(file2);
        FileOutputStream outputStream = new FileOutputStream(file2);

        byte[] tmp = new byte[inputStream.available()];
        while (inputStream.available() > 0)
        {
            int c = inputStream.read(tmp);
            outputStream.write(tmp,0,c);
            outputStream.write(tmp,inputStream.available(),c);


        }
        inputStream.close();
        outputStream.close();

    }
}
