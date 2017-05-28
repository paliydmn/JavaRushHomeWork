package com.javarush.test.level23.lesson04.task01;

/* Inner
Реализовать метод getTwoSolutions, который должен возвращать массив из 2-х экземпляров класса Solution.
Для каждого экземпляра класса Solution инициализировать поле innerClasses двумя значениями.
Инициализация всех данных должна происходить только в методе getTwoSolutions.
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution[] solution = new Solution[2];


        Solution sol1 = new Solution();
        Solution sol2 = new Solution();

        Solution.InnerClass inSol1  = sol1.new InnerClass();
        Solution.InnerClass inSol2  = sol1.new InnerClass();
        Solution.InnerClass inSol3  = sol2.new InnerClass();
        Solution.InnerClass inSol4  = sol2.new InnerClass();
        sol1.innerClasses[0] = inSol1;
        sol1.innerClasses[1] = inSol2;
        sol2.innerClasses[0] = inSol3;
        sol2.innerClasses[1] = inSol4;

        solution[0] = sol1;
        solution[1] = sol2;
        return solution;
    }
}
