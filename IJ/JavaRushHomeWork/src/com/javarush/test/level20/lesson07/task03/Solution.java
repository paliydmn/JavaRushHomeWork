package com.javarush.test.level20.lesson07.task03;

import java.io.*;
import java.util.List;

/* Externalizable Person
Класс Person должен сериализоваться с помощью интерфейса Externalizable.
Подумайте, какие поля не нужно сериализовать.
Исправьте ошибку сериализации.
Сигнатуры методов менять нельзя.
*/
public class Solution {
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        File file_name = new File("D:\\data.txt"); //File.createTempFile("D:\\data.txt", null);
        // File out_file_name = new File("D:\\result.txt"); //File.createTempFile("D:\\data.txt", null);
        Person father = new Person("test", "last", 26);

        InputStream inputStream = new FileInputStream(file_name);
       /* OutputStream outputStream = new FileOutputStream(file_name);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        father.writeExternal(objectOutputStream);
        objectOutputStream.close();
        outputStream.close();*/

        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        father.readExternal(objectInputStream);

        System.out.println(father.toString());

    }

    public static class Person implements Externalizable {
        private String firstName;
        private String lastName;
        private int age;
        private Person mother;
        private Person father;
        private List<Person> children;

        public Person(){super();}

        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public void setMother(Person mother) {
            this.mother = mother;
        }

        public void setFather(Person father) {
            this.father = father;
        }

        public void setChildren(List<Person> children) {
            this.children = children;
        }
        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(mother);
            out.writeObject(father);
            out.writeObject(firstName);
            out.writeObject(lastName);
            out.writeInt(age);
            out.writeObject(children);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            mother = (Person)in.readObject();
            father = (Person)in.readObject();
            firstName =(String) in.readObject();
            lastName =(String) in.readObject();
            age = in.readInt();
            children = (List<Person>)in.readObject();
        }

        @Override
        public String toString()
        {
            return firstName + lastName + age;
        }
    }
}
