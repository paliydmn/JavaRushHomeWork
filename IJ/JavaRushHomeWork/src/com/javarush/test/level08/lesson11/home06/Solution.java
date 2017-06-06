package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        ArrayList<Human> children = new ArrayList<Human>();

        children.add(new Human("child", true, 8,  new ArrayList<Human>()));
        children.add(new Human("child2", false, 4, new ArrayList<Human>()));
        children.add(new Human("child3", true, 5, new ArrayList<Human>()));

        ArrayList<Human> parents = new ArrayList<Human>();

        Human father = new Human("Father", true, 33, children);
        Human mother = new Human("Mother", true, 33, children);

        parents.add(father);
        parents.add(mother);

        Human grandFather1 = new Human("GrandFather1", true, 70, parents);
        Human grandFather2 = new Human("GrandFather2", true, 71, parents );
        Human grandMother1 = new Human("GrandMother1", false, 69, parents);
        Human grandMother2 = new Human("GrandMother2", false, 68, parents);

        System.out.println(grandFather1);
        System.out.println(grandFather2);
        System.out.println(grandMother1);
        System.out.println(grandMother2);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(children);

    }

    public static class Human
    {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<Human>();

       public Human(String name, boolean sex, int age, ArrayList<Human> children)
        {
            this.age = age;
            this.name = name;
            this.sex = sex;
            this.children = children;
        }

        public Human(String name, boolean sex)
        {
            this.name = name;
            this.sex = sex;
        }


        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
