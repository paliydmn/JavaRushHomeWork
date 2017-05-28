package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws FileNotFoundException, ParseException
    {

        String fileName = args[0];
        Scanner scanner = new Scanner(new FileReader(fileName));
        while (scanner.hasNext())
        {
            StringBuffer sbString = new StringBuffer();
            StringBuffer sbData = new StringBuffer();

            String tmp2 = null;
            String[] tmp = scanner.nextLine().split(" ");
                 for (String testStr : tmp )
                    {
                        try
                        {
                            int i = Integer.parseInt(testStr);
                            sbData.append(i + " ");

                        }
                        catch (NumberFormatException e)
                        {
                            sbString.append(testStr + " ");
                        }
                }
          //  System.out.println(sbString.toString());
           // System.out.println(sbData.toString());
            DateFormat format = new SimpleDateFormat("dd MM yyyy", Locale.ENGLISH);
            Date date = format.parse(sbData.toString());
            PEOPLE.add(new Person(sbString.toString().trim(),date));

            //System.out.println(date);
        }
        scanner.close();

        System.out.println(PEOPLE.get(0).getName() + " " + PEOPLE.get(0).getBirthday());
        System.out.println(PEOPLE.get(1).getName() + " " + PEOPLE.get(1).getBirthday());
    }

}
