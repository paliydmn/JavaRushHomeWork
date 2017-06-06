package com.javarush.test.level18.lesson10.home07;

/* Поиск данных внутри файла
Считать с консоли имя файла
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int)
Закрыть потоки. Не использовать try-with-resources

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity

где id - int
productName - название товара, может содержать пробелы, String
price - цена, double
quantity - количество, int

Информация по каждому товару хранится в отдельной строке
*/
import java.io.*;
import java.security.spec.ECField;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        String file = new BufferedReader(new InputStreamReader(System.in)).readLine();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line  = null;
        while ((line  = reader.readLine()) != null)
        {
            String[] sId = new String[4];
            sId = line.split(" ");
            int id = Integer.parseInt(sId[0]);
            //System.out.println(sId[0]);
            if(id == Integer.parseInt(args[0]))
            {
                System.out.println(line);
            }

            /*Scanner reader2 = new Scanner(line);
            int id = 0;
            try
            {
                while ((id = reader2.nextInt()) != 0)
                    if(id == Integer.parseInt(args[0]))
                    {
                        System.out.println(line);

                    }*/
            /*
            if(line.startsWith(args[0]))
            {
                System.out.println(line);

               // find only first matche
                break;

            }*/
          /*  }
            catch (Exception e){}
            reader2.close();*/
        }

        reader.close();
    }
}
