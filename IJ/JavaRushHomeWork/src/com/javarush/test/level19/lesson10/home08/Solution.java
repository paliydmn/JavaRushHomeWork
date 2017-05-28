package com.javarush.test.level19.lesson10.home08;

/* Перевертыши
1 Считать с консоли имя файла.
2 Для каждой строки в файле:
2.1 переставить все символы в обратном порядке
2.2 вывести на экран
3 Закрыть потоки. Не использовать try-with-resources

Пример тела входного файла:
я - программист.
Амиго

Пример результата:
.тсиммаргорп - я
огимА
*/

import java.io.*;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        Scanner scanner = new Scanner(new FileReader(fileName));

        while (scanner.hasNext())
        {
            String line = scanner.nextLine();
            char[] chars = line.toCharArray();
            for (int i = chars.length-1; i >= 0; i-- )
            {
                System.out.print(chars[i]);
            }
            System.out.println("\t");
        }
        scanner.close();
    }
}
