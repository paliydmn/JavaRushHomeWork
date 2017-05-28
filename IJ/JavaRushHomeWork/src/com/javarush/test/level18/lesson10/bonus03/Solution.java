package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //String reader = "D:\\data.txt";
        String reader = bufferedReader.readLine();
        if(args[0].endsWith("-u"))
        {
           Helper.findAndUpdateById(reader, args[1],args[2],args[3],args[4]);
        }
        if(args[0].equals("-d"))
        {
            Helper.removeById(reader,args[1]);
        }
    }
    public static class  Helper
    {
        public static void removeById (String reader, String id) throws IOException
        {
            int idForRemove = 0;
            boolean revrite = false;
            List<String> list = new ArrayList<String>();
            Scanner scanner = new Scanner(new FileReader(reader));
            while (scanner.hasNext())
            {
                list.add(scanner.nextLine());
            }
            for (int i = 0; i < list.size(); i++)
            {
                if(list.get(i).substring(0,8).trim().equals(id))
                {
                   idForRemove = i;
                   revrite = true;
                }
                else
                {
                    System.out.println("There is no such id in the list - " + id);
                }
            }
            if(revrite)
            {
                FileOutputStream outputStream = new FileOutputStream(reader);
                outputStream.close();
                if (idForRemove != 0)
                    list.remove(idForRemove);
                for (String str : list)
                    write(str, reader);
            }
        }
        public static void write(String what, String where) throws IOException
        {
            Scanner scanner = new Scanner(what);
            BufferedWriter bw = null;
            bw = new BufferedWriter(new FileWriter(where, true));
            bw.write(scanner.nextLine());
            bw.newLine();
            bw.flush();
            bw.close();
        }
        public static void findAndUpdateById(String reader, String id, String args2,String args3,String args4 ) throws IOException
        {
            List<String> list = new ArrayList<String>();
            Scanner scanner = new Scanner(new FileReader(reader));
            while (scanner.hasNext())
            {
                list.add(scanner.nextLine());
            }
            for (int i = 0; i < list.size(); i++)
            {
                if(list.get(i).substring(0,8).trim().equals(id))
                {
                    StringBuilder totalString = new StringBuilder();
                    totalString = totalString.append(list.get(i).substring(0,8)).append(productName(args2)).append(price(args3)).append(intQuantity(args4));
                    list.set(i,String.valueOf(totalString));
                }
            }
            FileOutputStream outputStream = new FileOutputStream(reader);
            outputStream.close();
            for (String str : list)
                write(str,reader);
        }
        public static String nextID(String reader ) throws FileNotFoundException
        {
            List<Integer> list = new ArrayList<Integer>();
            Scanner scanner = new Scanner(new FileReader(reader));
            while (scanner.hasNext())
            {
                String tmp = scanner.nextLine().substring(0,8).trim();
                BigDecimal bigDecimal = new BigDecimal(tmp.toCharArray(),0,tmp.toCharArray().length);
                list.add(Integer.parseInt(String.valueOf(bigDecimal)));
            }
            Collections.sort(list);
            int id = list.get(list.size()-1) + 1;
            String stringId = correctLength(String.valueOf(id), 8);
            return stringId;
        }
        public static String productName(String arg)
        {
            return correctLength(arg,30);
        }

        public  static String intQuantity (String args)
        {
            return correctLength(args,4);
        }

        public static String price (String args)
        {
            return  correctLength(args,8);
        }
    }
    public static String correctLength(String variable, int length)
    {
        StringBuilder sb = new StringBuilder();
        if(variable.length() > length)
        {
            variable = variable.substring(0,length);
        }
        else
        {
            for (int i = 0; i < length - variable.length(); i++)
                sb.append(" ");
            variable = variable + sb;
        }
        return variable;
    }

}

