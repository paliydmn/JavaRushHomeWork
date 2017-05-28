package com.javarush.test.level17.lesson10.bonus02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException
    {
        //start here - начни тут
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        synchronized (Person.class)
        {
            if (args[0].equals("-c"))
            {
                int tmp = 1;
                for (int i = 0; i < (args.length) / 3; i++)
                {
                    create(args[tmp], args[++tmp], format.parse(args[++tmp]));
                    tmp++;
                    String id = String.valueOf(allPeople.size() - 1);
                    System.out.println(id);
                }
            }

            if (args[0].equals("-u"))
            {
                int tmp = 1;
                for (int i = 0; i < (args.length) / 4; i++)
                {
                    update(args[tmp], args[++tmp], args[++tmp], format.parse(args[++tmp]));
                    tmp++;
                }
            }
            if (args[0].equals("-d"))
            {
                for (int i = 1; i < args.length; i++)
                {
                    delete(args[i]);
                }
            }
            if (args[0].equals("-i"))
            {
                for (int i = 1; i < args.length; i++)
                {
                    int tmp = Integer.parseInt(args[i]);
                    info(args[i]);
                }
            }
        }
    }

    public static void create(String name, String sex, Date bd)
    {
        if(sex.equals("м"))
            allPeople.add(Person.createMale(name,bd));
        else
            allPeople.add(Person.createFemale(name,bd));
    }
    public static void update(String sId, String name, String sSex, Date bd)
    {
        int id = Integer.parseInt(sId);
        allPeople.get(id).setName(name);
        if(sSex.equals("м"))
            allPeople.get(id).setSex(Sex.MALE);
        else
            allPeople.get(id).setSex(Sex.FEMALE);
        allPeople.get(id).setBirthDay(bd);
    }
    public static void delete(String sId)
    {
        int id = Integer.parseInt(sId);
        allPeople.get(id).setName(null);
        allPeople.get(id).setSex(null);
        allPeople.get(id).setBirthDay(null);
    }
    public static void info(String sId)
    {
        SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        int id = Integer.parseInt(sId);
        System.out.println(allPeople.get(id).getName() + " "+ ((allPeople.get(id).getSex() == Sex.FEMALE) ? "ж" : "м" ) + " " + format.format(allPeople.get(id).getBirthDay()));
    }
}
