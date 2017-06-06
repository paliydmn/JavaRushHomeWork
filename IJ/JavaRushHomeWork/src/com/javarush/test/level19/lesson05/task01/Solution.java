package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
Закрыть потоки ввода-вывода.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inData = reader.readLine();
        String outData = reader.readLine();
        reader.close();

        FileReader fileReader = new FileReader(inData);
        FileWriter fileWriter = new FileWriter(outData);
        int counter = 1;
        while (fileReader.ready())
        {
            int data = fileReader.read();
            if(counter % 2 == 0)
            {
                System.out.println( data);
                fileWriter.write(data);
            }
            counter++;
        }

        fileReader.close();
        fileWriter.close();
    }
}
