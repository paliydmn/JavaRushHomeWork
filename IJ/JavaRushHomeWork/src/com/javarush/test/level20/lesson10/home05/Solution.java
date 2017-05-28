package com.javarush.test.level20.lesson10.home05;

import java.io.*;
import java.util.logging.Logger;

/* Сериализуйте Person
Сериализуйте класс Person стандартным способом. При необходимости поставьте полям модификатор transient.
*/
public class Solution implements Serializable{


    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        // ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        // FileOutputStream foStream = new FileOutputStream("your.file.name");
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("your.file.name"));
        Person person = new Person("Dima", "Paliy","Ukraine",Sex.MALE);
       // System.out.println(person.country +" " + person.greetingString + " " + person.fullName );

        outputStream.writeObject(person);
        outputStream.close();
        Person loaded =new Person("");
        InputStream inputStream = new FileInputStream("your.file.name");
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        loaded = (Person) objectInputStream.readObject();

        System.out.println(loaded.country +" " + loaded.greetingString + " " + loaded.fullName + " " + loaded.sex);

    }


    public static class Person implements Serializable {
        String firstName;
        String lastName;
        transient String fullName;
        transient final String greetingString;
        String country;
        Sex sex;
        transient   PrintStream outputStream;
        transient  Logger logger;

        Person(String firstName, String lastName, String country, Sex sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);
            this.greetingString = "Hello, ";
            this.country = country;
            this.sex = sex;
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }


        public  Person(String greetingString){
            this.greetingString = greetingString;
        }

    }

    enum Sex {
        MALE,
        FEMALE
    }
}
