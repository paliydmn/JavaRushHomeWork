package com.dima.tests;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by Dima on 13.07.2016.
 */
public class GetClassMethods
{
    static void getMethods(Object target)
    {

        System.out.println(new TestClass().test2(123));

        Class clazz = target.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        for (Method m : methods)
            System.out.println(Modifier.toString(m.getModifiers()) + "   " + m.getName());
    }

    public static void main(String[] args)
    {
        getMethods(new TestClass());
    }

}

class TestClass
{
    void mymeth(){}
     String test2(int t){
        String toBinary = Integer.toBinaryString(t);
        return toBinary;}
    protected void test3()
    {
        System.out.println("protected");
    }

}