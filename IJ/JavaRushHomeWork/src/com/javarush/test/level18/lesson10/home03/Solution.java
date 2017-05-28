package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import javax.jws.soap.SOAPBinding;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();

        //FileInputStream in1 = new FileInputStream(file1);
        FileInputStream in2 = new FileInputStream(file2);
        FileOutputStream out2 = new FileOutputStream(file2);

        int len = (int)in2.available();
      //  byte[] buffer = new byte[in1.available()];

        System.out.println(len);
       /* System.out.println(in1.available());
        while (in1.available()>0)
        {
            int counter = in1.read(buffer);
            out2.write(buffer,len,counter);
            //System.out.println("test");
        }
*/

       /* while (in3.available()>0)
        {
            out1.write(in3.read());
        }
        in2.close();
        in3.close();
        out1.close();*/

    }
}
