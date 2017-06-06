package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;
public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, byte[]> map = new TreeMap<Integer, byte[]>();
        String resultname = "";
        while (true) {
            String filename = reader.readLine();
            if (filename.equals("end")) break;
            String[] namearray = filename.split(".part");
            resultname = namearray[0];

            FileInputStream inputStream = new FileInputStream(filename);
            byte[] arr = new byte[inputStream.available()];
            if (inputStream.available() > 0) inputStream.read(arr);
            map.put(Integer.parseInt(namearray[1]), arr);
            inputStream.close();
        }
        FileOutputStream outputStream = new FileOutputStream(resultname);
        for (Map.Entry<Integer, byte[]> pair : map.entrySet()) {
            outputStream.write(pair.getValue());
            outputStream.write(System.lineSeparator().getBytes());
            outputStream.flush();
        }
        outputStream.close();
        reader.close();
    }
}