package com.dima.tests;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dima on 21.01.2016.
 */
public class CollectionTest implements Serializable
{

    /*public static void main(String[] args)
    {
        HashMap<String,String> map = new HashMap<String, String>(createMap());

       // printHashMap( fillHashMap(createMap()));

        Map syncMap = Collections.synchronizedMap(map);

        Iterator<HashMap.Entry<String,String>> iterator = syncMap.entrySet().iterator();
        while (iterator.hasNext())
        {
            HashMap.Entry<String, String> pair = iterator.next();
            System.out.println(pair.getKey());
        }

    }*/
    public static HashMap<String, String> createMap()
    {
        HashMap<String, String> map = new HashMap<String, String>();
        return map;
    }
    public static HashMap<String,String> fillHashMap(HashMap<String,String> map)
    {
        for (int i = 0; i < 10; i++)
            map.put("Key" + i, "Value" + i);

        return map;
    }
    public static void printHashMap(HashMap<String, String> map)
    {
        for (Map.Entry<String,String> pair : map.entrySet())
        {
            System.out.println(pair.getKey());

        }
    }
}
