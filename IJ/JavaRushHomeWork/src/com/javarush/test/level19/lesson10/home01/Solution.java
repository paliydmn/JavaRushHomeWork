package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
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
        for (String tmp : stringSet)
            System.out.println(tmp);
    }
}
