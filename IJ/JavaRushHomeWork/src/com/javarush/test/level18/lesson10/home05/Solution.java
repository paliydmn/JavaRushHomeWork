package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        /*
         //tests
        String file1 = "D:\\result.txt";
        String file2 = "D:\\result2.txt";
        */

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();

        FileInputStream inputStream = new FileInputStream(file1);
        FileWriter outputStream = new FileWriter(file2);

        StringBuilder sb = new StringBuilder();
        while (inputStream.available() > 0)
        {
           sb.append((char) inputStream.read());
        }
        String[] s = String.valueOf(sb).split(" ");
        for (int i = 0; i < s.length; i++)
        {
            double tmp = Double.parseDouble(s[i]);
            if(tmp > 0)
            {
                double newDouble = new BigDecimal(tmp).setScale(0, RoundingMode.HALF_UP).doubleValue();
                outputStream.write(Integer.toString((int)newDouble) + " ");
            }else
            {
                double newDouble = new BigDecimal(tmp).setScale(0, RoundingMode.HALF_DOWN).doubleValue();
                outputStream.write(Integer.toString((int)newDouble) + " ");
            }
        }
        inputStream.close();
        outputStream.close();
    }
}
