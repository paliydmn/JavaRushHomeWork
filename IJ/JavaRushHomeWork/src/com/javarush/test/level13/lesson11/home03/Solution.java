package com.javarush.test.level13.lesson11.home03;

/* Чтение файла
1. Считать с консоли имя файла.
2. Вывести в консоль(на экран) содержимое файла.
3. Не забыть освободить ресурсы. Закрыть поток чтения с файла и поток ввода с клавиатуры.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        //add your code here

        //second variant
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream readFile = new FileInputStream("D:\\" + reader.readLine()+ ".txt");
        while (readFile.available() > 0)
        {
            System.out.print((char) readFile.read());
        }
        readFile.close();


       /*
       // first workable variant
       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();

        FileReader readFile = new FileReader("D:\\" + file + ".txt");
        int c;
        while ((c = readFile.read()) > 0)
        {
            System.out.print((char) c );
        }
        readFile.close();
*/
    }
}
