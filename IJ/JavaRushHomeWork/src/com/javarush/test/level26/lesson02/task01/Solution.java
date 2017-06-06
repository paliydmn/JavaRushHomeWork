package com.javarush.test.level26.lesson02.task01;

import java.util.Arrays;
import java.util.Comparator;

/* Почитать в инете про медиану выборки
Реализовать логику метода sort, который должен сортировать данные в массиве по удаленности от его медианы
Вернуть отсортированный массив от минимального расстояния до максимального
Если удаленность одинаковая у нескольких чисел, то выводить их в порядке возрастания
*/
public class Solution {
    public static Integer[] sort(Integer[] array) {
        //implement logic here

        final double median;

        Arrays.sort(array);
        int middle = array.length / 2;
        if(array.length % 2 == 1)
            median = array[middle];
        else
            median = ( array[middle-1] + array[middle] ) / 2.0;

        Comparator<Integer> compareByMedian = new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                return (int)(Math.abs(o1 - median)-Math.abs(o2 - median));
            }
        };
        Arrays.sort(array,compareByMedian);

        return array;
    }

    public static void main(String[] args)
    {
        Integer[] array = {5,8,13,15,17};
       sort(array);
       /*  for (Integer i : array)
            System.out.println(i);*/
    }
}
