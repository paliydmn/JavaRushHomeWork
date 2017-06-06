package com.javarush.test.level19.lesson10.home09;

/* Контекстная реклама
В методе main подмените объект System.out написанной вами реадер-оберткой
Ваша реадер-обертка должна выводить на консоль контекстную рекламу после каждого второго println-а
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Рекламный текст: "JavaRush - курсы Java онлайн"

Пример вывода:
first
second
JavaRush - курсы Java онлайн
third
fourth
JavaRush - курсы Java онлайн
fifth
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        String ad = "JavaRush - курсы Java онлайн";

        PrintStream consoleStream = System.out;
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(arrayOutputStream);
        System.setOut(printStream);

        testString.printSomething();
        String result = arrayOutputStream.toString();
        System.setOut(consoleStream);
        String[] arr = result.split("\\n");
        int counter = 1;
        for (String tmp : arr )
        {
            System.out.println(tmp);
            if(counter % 2 == 0)
            {
                System.out.println(ad);
            }
            counter++;
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
