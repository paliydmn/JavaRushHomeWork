package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        //напишите тут ваши переменные и конструкторы
        static String sex;
        static String name;
        static String address;
        static int age;
        static int weight;
        static boolean cheater;
        //1 constructor
        Human(String sex,String name)
        {
            this.sex = sex;
            this.name = name;
        }
        //2 constructor
        Human(String address)
        {
            this.address = address;
        }
        //3 constructor
        Human(int age,int weight)
        {
            this.age = age;
            this.weight = weight;
        }
        //4 constructor
        Human(String name, int age)
        {
            this.name = name;
            this.age = age;
        }
        //5 constructor
        Human(boolean cheater)
        {
            this.cheater = cheater;
        }
        //6 constructor
        Human(boolean cheater, String sex)
        {
            this.cheater = cheater;
            this.sex = sex;
        }
        //7 constructor
        Human(int age, String sex, boolean cheater)
        {
            this.age = age;
            this.sex = sex;
            this.cheater = cheater;
        }

        //8 constructor
        Human(int weight, String address, String sex)
        {
            this.weight = weight;
            this.sex = sex;
            this.address = address;
        }

        //9 constructor
        Human( String sex, String name, String address, int age)
        {
            this.age = age;
            this.address = address;
            this.name = name;
            this.sex = sex;

        }
        //10 constructor
        Human(String sex, String name, String address, int age, boolean cheater)
        {
            this.age = age;
            this.address = address;
            this.name = name;
            this.sex = sex;
            this.cheater = cheater;
        }



    }
}
