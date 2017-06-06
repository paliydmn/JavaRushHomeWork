package com.javarush.test.level17.lesson10.home09;

import java.io.*;
import java.nio.Buffer;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/* Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки, которые есть в forRemoveLines
4. Если список allLines НЕ содержит каких-либо строк, которые есть в forRemoveLines, то
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Метод joinData должен вызываться в main. Все исключения обработайте в методе main.
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        File fileOne = new File(reader.readLine());
        File filetwo = new File(reader.readLine());
        BufferedReader readerFiles1 = new BufferedReader( new FileReader(fileOne));
        BufferedReader readerFiles2 = new BufferedReader( new FileReader(filetwo));
        String tmp;
        while ((tmp = readerFiles1.readLine()) != null )
        {
            allLines.add(tmp);
        }

        while ((tmp = readerFiles2.readLine()) != null)
        {
            forRemoveLines.add(tmp);
        }

        List<String> copyAllLines = new ArrayList<String>(allLines);
        List<String> copyForRemoveLines = new ArrayList<String>(forRemoveLines);
        try
        {
            new Solution().joinData();
        }
        catch (Exception e)
        {
            allLines.clear();
            allLines.addAll(copyAllLines);
            forRemoveLines.clear();
            forRemoveLines.addAll(copyForRemoveLines);
        }

    }

    public void joinData () throws CorruptedDataException {

        if(allLines.containsAll(forRemoveLines))
            allLines.removeAll(forRemoveLines);
        else
        {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
