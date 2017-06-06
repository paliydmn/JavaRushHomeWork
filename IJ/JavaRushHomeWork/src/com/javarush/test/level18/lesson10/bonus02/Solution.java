package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

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
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
       //String reader = "D:\\data.txt";
        String reader = bufferedReader.readLine();
        if(args[0].endsWith("-c"))
        {
            String stringId =  Helper.nextID(reader);
            String productName = Helper.productName(args[1]);
            String doublePrice = Helper.price(args[2]);
            String intQuantity = Helper.intQuantity(args[3]);
            StringBuilder totalString = new StringBuilder();
            totalString = totalString.append(stringId).append(productName).append(doublePrice).append(intQuantity);
            String newProduct = String.valueOf(totalString);

            System.out.println(newProduct);

            Helper.write(newProduct, reader);
        }
    }

    public static class  Helper
    {
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

