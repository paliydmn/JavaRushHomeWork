package com.javarush.test.level14.lesson08.bonus01;
/*
import com.sun.deploy.security.CertificateConfigException;
import com.sun.deploy.security.UserDeclinedException;
import javax.xml.crypto.URIReferenceException;
import java.nio.charset.UnsupportedCharsetException;
import java.rmi.AlreadyBoundException;
import java.rmi.activation.ActivationException;
import java.security.GeneralSecurityException;
import java.util.zip.DataFormatException;*/

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/
import java.io.FileNotFoundException;
import java.util.*;

import java.util.List;

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {   //it's first exception
        try
        {
            float i = 1 / 0;

        } catch (Exception e)
        {
            exceptions.add(e);
        }

   /*     java.lang.ArithmeticException: / by zero
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        java.lang.NullPointerException
        java.lang.NumberFormatException: For input string: "test"
        java.lang.StringIndexOutOfBoundsException: String index out of range: 100
        java.lang.ArrayIndexOutOfBoundsException: 1
        java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
        java.lang.CloneNotSupportedException: com.javarush.test.level14.lesson08.bonus01.Solution
        java.text.ParseException: Unparseable date: "test"
        java.io.FileNotFoundException: test (Не удается найти указанный файл)
*/
        exceptions.add(new IndexOutOfBoundsException());
        exceptions.add(new NullPointerException());
        exceptions.add(new NumberFormatException());
        exceptions.add(new StringIndexOutOfBoundsException());
        exceptions.add(new ArrayIndexOutOfBoundsException("tests"));
        exceptions.add(new InterruptedException());
        exceptions.add(new ClassCastException("s"));
        exceptions.add(new CloneNotSupportedException());
        exceptions.add(new FileNotFoundException());
        //exceptions.add(new TransformException());
        //Add your code here
//2
       /* try
        {
            int[] b = new int[0];
            for (int i = 0; i < 10; i++)
                i = b[i];
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
//3
        try
        {
            File file = new File("test");
            Reader reader = new FileReader(file);

        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
//4
        exceptions.add(new ValueException("test"));
       *//* try
        {
            InputStream input = new InflaterInputStream(null);
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }*//*
//5
        try
        {
            String test = "test";
            int test2 = Integer.parseInt(test);
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }

//6
        try
        {
            Solution test = new Solution();
            test.clone();

        }
        catch (Exception e)
        {
            exceptions.add(e);
        }

//7
        try
        {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            Date lowDate = sdf.parse("test");

        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
        exceptions.add(new ParserException("testss"));
        exceptions.add(new RuntimeException());
        exceptions.add(new EmptyStackException());
*/
/*
        try
        {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            Date lowDate = sdf.parse("test");

        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
//9
        try
        {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            Date lowDate = sdf.parse("test");

        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
//10
        try
        {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            Date lowDate = sdf.parse("test");

        }
        catch (Exception e)
        {
            exceptions.add(e);
        }*/

    }
}
