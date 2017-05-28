package com.javarush.test.level08.lesson08.task04;

import java.util.*;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Сталлоне", new Date("JUNE 1 1980"));
        map.put("Ван дам", new Date("JULY 1 1980"));
        map.put("Шварц", new Date("AUGUST 1 1980"));
        map.put("Чан", new Date("OCTOBER 1 1980"));
        map.put("Вилис", new Date("MARCH 1 1980"));
        map.put("Норрис", new Date("APRIL 1 1980"));
        map.put("Лунгрен", new Date("SEPTEMBER 1 1980"));
        map.put("Стэтэм", new Date("NOVEMBER 1 1980"));
        map.put("Бандэрос", new Date("DECEMBER 1 1980"));
        map.put("Никулин", new Date("JUNE 1 1980"));
        //Напишите тут ваш код
        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        //Напишите тут ваш код
        int summer;
        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();
        while (iterator.hasNext())
        {
            Map.Entry<String, Date> pair = iterator.next();
            summer = pair.getValue().getMonth();
            if (summer >= 5 && summer <= 7)
                iterator.remove();
        }
    }
        public static void main (String[]args)
        {
            HashMap<String, Date> map;
            map = createMap();
            removeAllSummerPeople(map);
            System.out.println(map);

        }


        }

 /*ArrayList<String> keys = new ArrayList<String>();
        for (Map.Entry<String, Date> pair : map.entrySet())
        {
            if (pair.getValue().getMonth() >= 5 && pair.getValue().getMonth() <= 7)
            {
                keys.add(pair.getKey());
            }
        }
        for (int i = 0; i < keys.size(); i++)
        {
            map.remove(keys.get(i));
        }
        System.out.println(map);
    }*/

   /* public static void main(String[] args)
    {
        System.out.println(createMap());
        removeAllSummerPeople(createMap());*/
    /*public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stal", new Date("JULY 4 1984"));
        map.put("Stallone", new Date("JUNE 1 1980"));
        map.put("Stall", new Date("MARCH 4 1984"));
        map.put("Stll", new Date("APRIL 4 1984"));
        map.put("Ssdtll", new Date("AUGUST 4 1984"));
        map.put("Sssdrtdtll", new Date("SEPTEMBER 6 1944"));
        //напишите тут ваш код
        return map;

    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        //напишите тут ваш код


        HashMap<String, Date> mapcopy = new HashMap<String, Date>(map);
        for (Map.Entry<String, Date> pair : mapcopy.entrySet())
            if (pair.getValue().getMonth() >= 5 && pair.getValue().getMonth() <= 7)
                map.remove(pair.getKey());



*//*

        Iterator<Map.Entry<String, Date>> temp = map.entrySet().iterator();
        while (temp.hasNext()) {
            Date d = temp.next().getValue();
            if (d.getMonth() > 4 && d.getMonth() < 8)
                temp.remove();
        }


*//*

       *//* int summer;

        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();
        while (iterator.hasNext())
        {
            Map.Entry<String, Date> pair = iterator.next();
            summer = pair.getValue().getMonth();
            if (summer >= 5 && summer <=7)
                iterator.remove();
*//*
//            if(pair.getValue().getMonth() >=5 && pair.getValue().getMonth() <= 7 )
//            {
//                pair.remove();
//            }



        *//*for (Map.Entry<String, Date> pair: map.entrySet())
        {

            if(pair.getValue().getMonth() >=5 && pair.getValue().getMonth() <= 7 )
            {
                map.remove(pair.getKey());
            }

        }*//*

    }
*/

