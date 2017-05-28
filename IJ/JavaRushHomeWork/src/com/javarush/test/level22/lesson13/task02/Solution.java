package com.javarush.test.level22.lesson13.task02;

import java.io.*;
import java.nio.charset.Charset;

/* Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {
/*        Charset windows1251 = Charset.forName("Windows-1251");
        Charset utf8 = Charset.forName("UTF-8");


        byte[] buffer = win1251TestString.getBytes(windows1251);
        String s = new String(buffer);
        System.out.println(s);
        buffer = s.getBytes(utf8);
        String s2 = new String(buffer);
        System.out.println(s2);*/

        String inputFileName = args[0];
        String outputFileName = args[1];
    //    System.out.println(String.format("%s : %s", inputFileName,outputFileName));

      //  InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(inputFileName));
        InputStream inputStream = new FileInputStream(inputFileName);
        Charset utf8 = Charset.forName("UTF-8");
        Charset windows1251 = Charset.forName("Windows-1251");

        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes);
        inputStream.close();


        String s = new String(bytes, utf8);
       // System.out.println(s);
        bytes = s.getBytes(windows1251);

        String s2 = new String(bytes);
       // System.out.println(s2);

        OutputStream outputStream = new FileOutputStream(outputFileName);
        outputStream.write(bytes);
        outputStream.close();

    }
}
