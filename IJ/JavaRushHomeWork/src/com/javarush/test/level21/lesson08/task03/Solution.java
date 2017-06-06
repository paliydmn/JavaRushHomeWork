package com.javarush.test.level21.lesson08.task03;

/* Запретить клонирование
Разрешите клонировать класс А
Запретите клонировать класс B
Разрешите клонировать класс C
Метод main не участвует в тестировании.
*/
public class Solution {

    public static void main(String[] args)
    {
        A a = new A(12,21);
        B b = new B(120,210, "B");
        C c = new C(1,2, "C");

        A clone = null;
        B cloneB = null;
        C cloneC = null;

        try {
            clone = a.clone();
            //cloneB = b.clone();
            cloneC = c.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println(a);
        System.out.println(clone);

        System.out.println(c.getI());
        System.out.println(cloneC.getName());



         System.out.println(a.i);
         System.out.println(clone.i);


    }
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }
        @Override
        public A clone() throws CloneNotSupportedException
        {
            return new A(getI(),getJ());
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public B clone() throws CloneNotSupportedException
        {
            throw new CloneNotSupportedException();
        }

    }

    public static class C extends B  implements Cloneable  {
        public C(int i, int j, String name) {
            super(i, j, name);
        }

        @Override
        public C clone()  throws CloneNotSupportedException
        {
            if(getName() != null)
            return new C(getI(),getJ(),getName());
            else
                return new C(getI(),getJ(),null);
        }

    }
}
