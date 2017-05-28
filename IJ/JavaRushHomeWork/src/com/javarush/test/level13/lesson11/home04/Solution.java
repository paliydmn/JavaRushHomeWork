package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой стороки.
*/

import java.io.*;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileOutputStream outFile = new FileOutputStream(reader.readLine());
        ArrayList<String> list = new ArrayList<String>();

        while (true)
        {
            String s = reader.readLine();
            if(s.equals("exit"))
            {
                list.add(s + '\n');
                break;
            }
            list.add(s + '\n');
        }
        for (String text:list)
            {
                byte[] data = text.getBytes();
                outFile.write(data);
            }
        outFile.close();
    }


}
