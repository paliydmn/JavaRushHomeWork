package com.javarush.test.level08.lesson08.task05;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        //Напишите тут ваш код
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("A", "Oleg");
        map.put("B", "Sasha");
        map.put("C", "Andrey");
        map.put("D", "Kolya");
        map.put("E", "Vasya");
        map.put("F", "Petya");
        map.put("G", "Andrey");
        map.put("H", "Oleg");
        map.put("I", "Sasha");
        map.put("J", "Andrey");
        return map;
    }
    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        HashMap<String, String> tmp = new HashMap<String, String>(); //тут всегда будет храниться одна пара (K,V)
        HashMap<String, String> copy = new HashMap<String, String>(map); //по копии будем пробегаться в цикле(не меняя её)
        Iterator<Map.Entry<String, String>> iterator = copy.entrySet().iterator(); // copy!
        while (iterator.hasNext())
        {
            Map.Entry<String, String> pair = iterator.next();
            if(map.containsValue(pair.getValue())) //если map еще содержит такое же значение, как и в копии
                tmp.put(pair.getKey(), pair.getValue()); // то заносим это значение во временную коллекцию
            map.remove(pair.getKey()); // удаляем текущее значение из map, что бы оно не учавствовало в следующем методе
            int size = map.size(); //размер до
            removeItemFromMapByValue(map, pair.getValue());
            int size2 = map.size(); //размер после
            if(size == size2) // если одинаковых имен не нашлось
            {
                map.putAll(tmp); // возвращаем ныне удаленное значение обратно в map
            }
            tmp.clear(); //чистим времянку
        }
    }
    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }
}















/*
    public static HashMap<String, String> createMap()
    {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<String, String>();
                map.put("Smitt", "Will");
                map.put("Smittdko", "Will");
                map.put("Smitdtko", "Will");
                map.put("Smisttsko", "Will");
                map.put("Smittasdko", "Will");
                map.put("Pity", "Bread");
                map.put("Chean", "Jakie");
                map.put("Taislor", "Bod");
                map.put("Gody", "Bob");
                map.put("Godich", "Bob");
                map.put("Goch", "Bob");

        return map;
    }

     public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
        {
            HashMap<String, String> copy = new HashMap<String, String>(map);
            for (String value : copy.values())
                if (Collections.frequency(copy.values(), value) > 1)
                    removeItemFromMapByValue(map, value);
        }



    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }*/
