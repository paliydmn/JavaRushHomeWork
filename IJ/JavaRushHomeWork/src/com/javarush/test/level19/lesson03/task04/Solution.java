package com.javarush.test.level19.lesson03.task04;

import java.io.IOException;
import java.util.*;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей, данные одного человека находятся в одной строке. Метод read() должен читать данные одного человека.
*/

public class Solution {
    public static void main(String[] args)
    {
        String[] test = "31 12 1950".split(" ");
        Calendar calendar = new GregorianCalendar(Integer.parseInt(test[0]), Integer.parseInt(test[1])-1, Integer.parseInt(test[2]));
        System.out.println(calendar.getTime());

    }

    public static class PersonScannerAdapter implements PersonScanner{
        private Scanner scanner;
        public PersonScannerAdapter(Scanner scanner)
        {
            this.scanner = scanner;
        }
        @Override
        public Person read() throws IOException
        {
            String[] personData = scanner.nextLine().split(" ");
            String firstName = personData[1];
            String middleName = personData[2];
            String lastName = personData[0];
            Calendar calendar = new GregorianCalendar(Integer.parseInt(personData[5]), Integer.parseInt(personData[4])-1, Integer.parseInt(personData[3]));
            Person person = new Person(firstName,  middleName, lastName,  calendar.getTime());
            return person;
        }

        @Override
        public void close() throws IOException
        {
            scanner.close();
        }
    }
}
