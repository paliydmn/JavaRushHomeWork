package com.javarush.test.level22.lesson09.task03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/
public class Solution {
    public static void main(String[] args) throws IOException
    {
        //...
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       // String file = reader.readLine();
        String file = "D:\\data.txt";

        reader.close();
        FileReader fileReader = new FileReader(file);
        Scanner scanner = new Scanner(fileReader);
        List<String> list = new LinkedList<String>();
        while (scanner.hasNext())
        {
            list.add(scanner.next());
        }
        fileReader.close();
        scanner.close();

        String[] words = new String[list.size()];
        words = list.toArray(words);

        StringBuilder result = getLine(words);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder sb = new StringBuilder();

        if(words.length==0 || words==null)
            return sb;

        if(words.length == 1)
        {
            return sb.append(words[0]);
        }

        List<String> tmp = new ArrayList<String>();
        Collections.addAll(tmp, words);

        int iteration = 0;
        int middle = 0;
        boolean isTrue = true;
       /*for (int t = 0; t < 50; t++)
       {
*/
           while (isTrue)
           {
               Collections.shuffle(tmp);
               sb.append(tmp.get(0)).append(" ");
               for (int i = 1; i < tmp.size(); i++)
               {
                   String lastCh = sb.substring(sb.length()-2, sb.length()-1) ;
                   for (int x = 1; x < tmp.size(); x++)
                   {
                       String firstCh = tmp.get(x).substring(0,1);
                       firstCh = firstCh.toLowerCase();
                       lastCh = lastCh.toLowerCase();

                       if(lastCh.equalsIgnoreCase(firstCh))
                       {
                           sb.append(tmp.get(x)).append(" ");
                       }
                   }
               }

               if(sb.toString().split(" ").length != tmp.size())
               {
                   sb = new StringBuilder();
               }
               else
                   isTrue = false;


        //       iteration++;
           }
      //      middle += iteration;
    //   }

       // System.out.println("middle = " + middle/50);


                 sb.setLength(sb.length()-1);
          return sb;
    }
}
