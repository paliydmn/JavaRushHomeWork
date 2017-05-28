package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //String file = reader.readLine();
        String file = ("D:\\data.txt");
        String openTag = "<" + args[0];

        String closeTag = "/" + args[0] + ">";
        List<String> fileLines = new ArrayList<String>();
        StringBuffer stringBuffer = new StringBuffer();
        Scanner scanner = new Scanner(new FileReader(file));
        while (scanner.hasNext())
        {
            String line = scanner.nextLine();
            stringBuffer.append(line);
        }
        System.out.println(stringBuffer.toString());
        String splitTag = args[0];

        String[] tegArr = stringBuffer.toString().split(splitTag);
        for (String  tmp : tegArr)
            System.out.println(tmp);

        int openCounter = 0;
        StringBuffer template = new StringBuffer();
        for (int i = 0; i < tegArr.length; i++)
        {

            if(tegArr[i].charAt(tegArr[i].length() - 1) == '<')
            {
                template.append(openTag).append(tegArr[i+1].substring(0,tegArr[i+1].length()-1));

            }else
           /* if(tegArr[i].startsWith(">"))
            {
                String line = tegArr[i-1];
                template.append(line);

            }*/
            if(tegArr[i].charAt(tegArr[i].length() - 1) == '/')
            {
                template.append(tegArr[i].substring(1,tegArr[i].length()-1));
                template.append(closeTag);
                i++;
            }
            System.out.println(template.toString());

        }
    }
}
