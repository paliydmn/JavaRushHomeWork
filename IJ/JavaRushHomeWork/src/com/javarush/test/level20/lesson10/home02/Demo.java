package com.javarush.test.level20.lesson10.home02;

import java.io.*;

/**
 * Created by Dima on 18.05.2016.
 */
public class Demo
{
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        com.javarush.test.level20.lesson10.home02.Solution solution = new com.javarush.test.level20.lesson10.home02.Solution();
        com.javarush.test.level20.lesson10.home02.Solution.B b = solution.new B();
        ByteArrayOutputStream buff = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(buff);
        out.writeObject(b);
        out.flush();
        out.close();
        solution.getOriginalObject(new ObjectInputStream(new ByteArrayInputStream(buff.toByteArray())));
    }
}
