package com.javarush.test.level22.lesson09.task01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример содержимого файла
рот тор торт о
о тот тот тот
Вывод:
рот тор
о о
тот тот
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        //String fileName = "D:\\data.txt";
        FileInputStream fileInputStream = new FileInputStream(fileName);
        List<String> lis = new ArrayList<String>();
        Scanner scanner = new Scanner(fileInputStream);


        while (scanner.hasNext()){
            lis.add(scanner.next());
        }
        scanner.close();
        fileInputStream.close();
        for (int i = 0; i < lis.size(); i++){
            String tmp = lis.get(i);
            for (int a = i+1; a < lis.size(); a++ ){
                String comp = lis.get(a);
                StringBuilder sb = new StringBuilder(comp);
                if(tmp.equals(sb.reverse().toString()))
                {
                    Pair p = new Pair(tmp,comp);
                    result.add(p);
                    lis.remove(i);
                }
            }
        }
        System.out.println(result.toString());
    }

    public static class Pair {
        String first;
        String second;

        public Pair(String first, String second)
        {
            this.first = first;
            this.second = second;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }
}
