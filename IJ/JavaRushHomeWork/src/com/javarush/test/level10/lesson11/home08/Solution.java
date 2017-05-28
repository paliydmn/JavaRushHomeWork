package com.javarush.test.level10.lesson11.home08;

import java.util.ArrayList;
//import java.util.List;

/* Массив списков строк
Создать массив, элементами которого будут списки строк. Заполнить массив любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<String>[] arrayOfStringList =  createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList()
    {
       ArrayList<String>[] arrayOfStringList = new ArrayList[10];
        for (int i = 0; i < 10; i++)
        {
            arrayOfStringList[i] = new ArrayList<String>();
            for (int b =0; b < arrayOfStringList.length; b++)
            {
                arrayOfStringList[i].add(b,"test");
            }
        }
        return arrayOfStringList;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList)
    {
        int counter = 0;
        for (ArrayList<String> list: arrayOfStringList)
        {
            for (String s : list)
            {
                System.out.println(++counter + s);
            }
        }
    }
}