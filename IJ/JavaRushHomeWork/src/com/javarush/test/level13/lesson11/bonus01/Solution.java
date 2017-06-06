package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String FileName = reader.readLine();

        //FileInputStream readFile = new FileInputStream(FileName);
        ArrayList<Integer> Count = new ArrayList<Integer>();

        Path path = Paths.get(FileName);
        Scanner scanner = new Scanner(path);
        //читаем построчно
        while(scanner.hasNextLine())
        {
            String line = scanner.nextLine();
            if ((Integer.parseInt(line)) % 2 == 0)
            Count.add(Integer.parseInt(line));
        }
        //readFile.close();

        Collections.sort(Count);
        for (int i : Count)
        {
            System.out.println(i);
        }
    }
}
