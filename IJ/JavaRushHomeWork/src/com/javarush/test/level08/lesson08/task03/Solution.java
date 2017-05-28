package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static void main(String[] args)
    {
        System.out.println(getCountTheSameFirstName(createMap(), "jack"));
        System.out.println(getCountTheSameLastName(createMap(), "Smit"));
    }
    public static HashMap<String, String> createMap()
    {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("jack", "Smit");
        map.put("jack2", "Smit");
        map.put("jack3", "Smit5");
        map.put("jack4", "Smit");
        map.put("jack5", "Smit");
        map.put("jack6", "Smit");
        map.put("jack7", "Smit");
        map.put("jack8", "Smit");
        map.put("jack9", "Smit");
        map.put("jack10", "Smit10");

        return map;

    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        //напишите тут ваш код
       // name = "Plaiy2";
        /*int counter = 0;
        for (Map.Entry<String, String> pair : map.entrySet())
        {
            if (name.equals(pair.getKey()))
                counter++;
        }

        return counter;*/
        int counter = 0;
        for (Map.Entry<String, String> pair : map.entrySet())
        {
            if (pair.getValue().equals(name))
                counter++;
        }

        return counter;


    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName)
    {
        //напишите тут ваш код
       // lastName = "Dima4";
        return map.containsKey(lastName) ? 1 : 0;

    }
}