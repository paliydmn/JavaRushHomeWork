package com.javarush.test.level17.lesson10.bonus01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/

public class Solution
{
    public static List<Person> allPeople = new ArrayList<Person>();

    static
    {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }
    public static void main(String[] args) throws ParseException
    {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
       if (args[0].equals("-c") && args.length == 4)
            {
                Date date = format.parse(args[3]);
                create(args[1], args[2], date);
                String id = String.valueOf(allPeople.size() - 1);
                System.out.println(id);
            }
            if (args[0].equals("-u") && args.length == 5)
            {

                update(args[1], args[2], args[3],format.parse(args[4]));
            }
            if (args[0].equals("-d") && args.length == 2)
            {
                delete(args[1]);
            }
            if (args[0].equals("-i") && args.length == 2)
            {
                info(args[1]);
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
        //allPeople.remove(id);
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