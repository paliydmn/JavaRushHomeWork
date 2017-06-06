package com.javarush.test.level20.lesson10.home03;

import java.io.*;

/* Найти ошибки
Почему-то при сериализации/десериализации объекта класса B возникают ошибки.
Найдите проблему и исправьте ее.
Класс A не должен реализовывать интерфейсы Serializable и Externalizable.
Сигнатура класса В не содержит ошибку :)
Метод main не участвует в тестировании.
*/
public class Solution implements Serializable{

    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        Solution solution = new Solution();
       // Solution.B b = solution.new B();
       B b = solution.new B("T");

        ByteArrayOutputStream buff = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(buff);
        out.writeObject(b);
        out.flush();
        out.close();
        System.out.println(b.name);

        ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(buff.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(arrayInputStream);
        B bb = (B)ois.readObject();

        System.out.println(bb.name);
        //solution.getOriginalObject(new ObjectInputStream(new ByteArrayInputStream(buff.toByteArray())));
    }


    public static class A{
         protected String name = "A";

        public A(String name) {
            this.name += name;
        }
        public A(){}

    }

    public  class B extends A implements Serializable {
        public B(String name)
        {
            super(name);
            this.name += name;
        }
       private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
            s.defaultReadObject();
            name = (String)s.readObject();
        }
        private void writeObject(ObjectOutputStream s) throws IOException {
            s.defaultWriteObject();
            s.writeObject(this.name);
        }

    }
}
