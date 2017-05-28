package com.javarush.test.level15.lesson12.home07;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* Файл в статическом блоке
1. Инициализируй константу Constants.FILE_NAME полным путем к файлу с данными, который содержит несколько строк.
2. В статическом блоке считай из файла с именем Constants.FILE_NAME все строки и добавь их по-отдельности в List lines.
3. Закрой поток ввода методом close().
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();
    static
    {
        Path path = Paths.get(Constants.FILE_NAME);
        Scanner scanner = null;
        try
        {
            scanner = new Scanner(path);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        while (scanner.hasNext())
        {
            String tmp = scanner.nextLine();
            lines.add(tmp);
        }
        scanner.close();
    }

    public static void main(String[] args) {
        System.out.println(lines);
    }
}
