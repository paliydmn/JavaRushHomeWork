package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
4. Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        FileInputStream inputStream = new FileInputStream(args[0]);
        int counterOfspaces = 0;
        int counterOfchars = inputStream.available();
        char space = ' ';
        while (inputStream.available()>0)
        {
            char tmp = (char)inputStream.read();
            if(tmp == space)
                counterOfspaces++;
        }
        inputStream.close();

        double result = 0;
        if (counterOfspaces != 0)
        {
            result = (double) counterOfspaces/counterOfchars*100;
        }
        NumberFormat format = new DecimalFormat("#0.00");
        System.out.println(format.format(result));

    }
}
