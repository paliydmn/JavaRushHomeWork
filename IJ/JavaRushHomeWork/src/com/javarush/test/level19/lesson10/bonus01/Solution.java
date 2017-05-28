package com.javarush.test.level19.lesson10.bonus01;

import java.io.*;
import java.util.*;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
оригинальный   редактированный    общий
file1:         file2:             результат:(lines)

строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка4                           REMOVED строка4
строка5        строка5            SAME строка5
строка0                           ADDED строка0
строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка5                           ADDED строка5
строка4        строка4            SAME строка4
строка5                           REMOVED строка5
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 =  "D:\\data.txt";
        String file2 =  "D:\\result.txt";
        /*String file1 =  reader.readLine();
        String file2 = reader.readLine();*/
        reader.close();

        Scanner scanner1 = new Scanner(new FileReader(file1));
        Scanner scanner2 = new Scanner(new FileReader(file2));
        List<String> list1 = new ArrayList<String>();
        List<String> list2 = new ArrayList<String>();
        while (scanner1.hasNext())
        {
            list1.add(scanner1.nextLine());
        }
        scanner1.close();
        while (scanner2.hasNext())
        {
            list2.add(scanner2.nextLine());
        }
        scanner2.close();



        int one = 0;
       // int two = 1;
        for (int i = 0; i < list2.size(); i++)
        {
           try
           {

               for (int q = 0; q < list1.size(); q++)
               {
                   //System.out.println("iteration  - " + q);
                   String list1line = list1.get(q);
                   String list2line = list2.get(0);
                   String list2line2 = list2.get(1);
                   if (list2line.equals(list1line))
                   {
                       LineItem lineItem = new LineItem(Type.SAME, list2.get(one));
                       lines.add(lineItem);
                       System.out.println(lineItem);
                       String tmp = list2.get(0);
                       //System.out.println(tmp);
                       list2.remove(0);
                   }
                   else if (list2line2.equals(list1line))
                   {
                       LineItem lineItem = new LineItem(Type.ADDED, list2line);
                       lines.add(lineItem);
                       System.out.println(lineItem);
                       String tmp = list2.get(0);
                       list2.remove(0);
                       q--;
                   } else if (!list2line2.equals(list1line))
                   {
                       LineItem lineItem = new LineItem(Type.REMOVED, list1line);
                       lines.add(lineItem);
                       String tmp = list2.get(0);
                       System.out.println(lineItem);
                   }
               }
           }
           catch (IndexOutOfBoundsException e)
           {

               System.out.println("cought" + e);
           }
        }
/*
            for (LineItem tmp : lines)
            {
                System.out.println(tmp.toString());
            }*/
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
        @Override
        public String toString()
        {

            String text = type.toString() + " " + line;

            return text;
        }
    }
}
