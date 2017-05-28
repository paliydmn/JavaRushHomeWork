package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException
    {
        String fileName = args[0];
        Map<String, Double> map = new TreeMap<String, Double>();

        Scanner scanner = new Scanner(new FileReader(fileName));
        int c =0;
        String line =null;
        Set<String> stringSet = new TreeSet<String>();
        while (scanner.hasNext())
        {
            line = scanner.nextLine();
            String[] sTmp = line.split(" ");
            String nameVal = sTmp[0];
            Double saleryVal = Double.parseDouble(sTmp[1]);
            map.put(nameVal + " " + ++c,saleryVal);
        }

        scanner.close();
        for (Map.Entry<String,Double> pair : map.entrySet())
        {
            double salary = 0.0;
            double salary2 = 0.0;
            String name = pair.getKey().split(" ")[0];
            salary = pair.getValue();
            for (Map.Entry<String,Double> pair2 : map.entrySet())
            {
                if (name.equals(pair2.getKey().split(" ")[0]))
                {
                    salary2 += pair2.getValue();
                }
            }
            stringSet.add(name + " " + salary2);
        }
        String reach = null;
        double max = 0.0;
        for (String tmp : stringSet)
        {
            max = Double.parseDouble(tmp.split(" ")[1]);
            for (String tmp2 : stringSet)
            {
                double d = Double.parseDouble(tmp2.split(" ")[1]);
                if(max < d)
                {
                    max = d;
                    reach = tmp2.split(" ")[0];
                }
            }
        }
        System.out.println(reach);
    }
}
