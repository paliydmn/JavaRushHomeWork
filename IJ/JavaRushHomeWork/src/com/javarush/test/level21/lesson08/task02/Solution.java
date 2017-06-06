package com.javarush.test.level21.lesson08.task02;

/* Клонирование
Класс Plant не должен реализовывать интерфейс Cloneable
Реализуйте механизм глубокого клонирования для Tree.
Метод main изменять нельзя.
*/
public class Solution{
    public static void main(String[] args) {
        Tree tree = new Tree("willow", new String[]{"s1", "s2", "s3", "s4"});

        Tree clone = null;
        try {
            clone = tree.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println(tree);
        System.out.println(clone);

       // System.out.println(tree.branches.toString());
       // System.out.println(clone.branches.toString());
    }

    public static class Plant{
        private String name;

        public Plant(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }


    public static class Tree extends Plant implements Cloneable{
        private String[] branches;
        @Override
        public String toString()
        {
            StringBuffer sb = new StringBuffer();
            for (String br : branches)
            sb.append(" " + br );

            return ( getName() + sb.toString());
        }

        public Tree(String name, String[] branches) {
            super(name);
            this.branches = branches;
        }

        public String[] getBranches() {
            return branches;
        }
        @Override
        public Tree clone() throws CloneNotSupportedException
        {

            Tree cloneTree = null;
/*            String[] brancheClone
            for (String branch : branches)
            {
                */
            if(getBranches() != null)
                cloneTree = new Tree(getName(),getBranches().clone());
            else
                cloneTree = new Tree(getName(),null);
            //          }

            return cloneTree;
        }
    }
}
