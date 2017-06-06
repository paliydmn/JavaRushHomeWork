package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.*;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException, InterruptedException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = null;
        while (!(fileName = reader.readLine()).equals("exit"))
        {
           ReadThread thread = new ReadThread(fileName);
            thread.start();
            thread.join();
        }
        reader.close();

        //System.out.println(resultMap.size());
        for (Map.Entry<String, Integer> pair : resultMap.entrySet())
        {
            System.out.println(pair.getKey() + " - " + pair.getValue() );
        }

    }

    public static class ReadThread extends Thread {
        private String fileName;
        public ReadThread(String fileName) {
            //implement constructor body
                        this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут
        @Override
        public void run()
        {
            try
            {
                List<Integer> bytesSet = new ArrayList<Integer>();
                TreeMap<Integer, Integer> byteMap = new TreeMap<Integer, Integer>();

                FileInputStream inputStream = new FileInputStream(fileName);
                while (inputStream.available() > 0)
                {
                    int b = inputStream.read();
                    bytesSet.add(b);
                }
                inputStream.close();
                for (Integer i : bytesSet)
                    byteMap.put(i,0);
                for (Integer i : bytesSet)
                {
                    for (Map.Entry<Integer,Integer> pair : byteMap.entrySet())
                    {
                        if(pair.getKey() == i){
                            int tmp = pair.getValue();
                            pair.setValue(++tmp);
                        }
                    }
                }

                int maxCounted = 0;
                int the_byte = 0;
                    for (Map.Entry<Integer, Integer> pair : byteMap.entrySet())
                    {
                        maxCounted = pair.getValue();
                        for (Map.Entry<Integer, Integer> pair2 : byteMap.entrySet())
                        {
                            if (maxCounted <= pair2.getValue())
                            {
                                maxCounted = pair2.getValue();
                                the_byte = pair2.getKey();
                               // System.out.println(maxCounted + " = max ");
                            }
                    }
                }
                resultMap.put(fileName, the_byte);
            }
            catch (FileNotFoundException e)
            {
                e.printStackTrace();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

        }
    }
}

