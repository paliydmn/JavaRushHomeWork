package com.dima.tests.resourceBundle;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Dima on 13.10.2016.
 */
public class resourceBundlTest
{
    public static final String RESOURCE_PATH = "com.dima.tests.resourceBundle.resources.";
    public static void main(String[] args)
    {
        Locale locale = new Locale("en", "US");
        ResourceBundle resourceBundle = ResourceBundle.getBundle(RESOURCE_PATH + "myTestResource", locale);
        Enumeration<String> e = resourceBundle.getKeys();


        while (e.hasMoreElements())
        {
            System.out.println(e.nextElement());
            System.out.println(resourceBundle.getString(e.nextElement()));
        }

       // System.out.println(resourceBundle.getString("test1"));

        if(resourceBundle.getString("code").equals("1234"))
            System.out.println(resourceBundle.getString("success_action"));

    }
}
