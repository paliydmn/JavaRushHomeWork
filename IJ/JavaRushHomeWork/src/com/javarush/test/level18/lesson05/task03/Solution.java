package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        FileOutputStream fileOutputStream2 = new FileOutputStream(reader.readLine());
        FileOutputStream fileOutputStream3 = new FileOutputStream(reader.readLine());

        //for quick tests

        /*FileInputStream inputStream = new FileInputStream("D:\\data.txt");
        FileOutputStream fileOutputStream2 = new FileOutputStream("D:\\result.txt");
        FileOutputStream fileOutputStream3 = new FileOutputStream("D:\\result2.txt");
        */
        byte[] buffer = new byte[inputStream.available()];
        int even = inputStream.available() % 2;
        while (inputStream.available() > 0)
        {
                if(even == 0)
                {
                    int count = inputStream.read(buffer);
                    fileOutputStream2.write(buffer, 0, count / 2);
                    fileOutputStream3.write(buffer, count / 2, count / 2);
                }
                else
                {
                    int count = inputStream.read(buffer);
                    fileOutputStream3.write(buffer, 0,count/2);
                    fileOutputStream2.write(buffer, count/2, count/2+1);
                }
        }
        reader.close();
        inputStream.close();
        fileOutputStream2.close();
        fileOutputStream3.close();
    }
}
