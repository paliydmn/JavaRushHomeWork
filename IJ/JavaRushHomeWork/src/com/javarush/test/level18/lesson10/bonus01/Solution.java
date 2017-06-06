package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException
    {

        System.out.println(args[0] + args[1] + args[2]);

        if(args[0].equals("-e"))
        {
            FileInputStream inputStream = new FileInputStream(args[1]);
            FileOutputStream outputStream = new FileOutputStream(args[2]);
            while (inputStream.available() > 0)
            {
                int key = inputStream.read() + 5;
                outputStream.write(key);
            }
            inputStream.close();
            outputStream.close();
        }
        if(args[0].equals("-d"))
        {
            FileInputStream inputStream = new FileInputStream(args[1]);
            FileOutputStream outputStream = new FileOutputStream(args[2]);
            while (inputStream.available() > 0)
            {
                int key = inputStream.read() - 5;
                outputStream.write(key);
            }

            inputStream.close();
            outputStream.close();
        }
    }

}
