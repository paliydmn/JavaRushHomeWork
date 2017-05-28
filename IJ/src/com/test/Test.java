package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

/**
 * Created by Dima on 28.12.2015.
 */
/* Реализовать метод addPrice
Реализовать метод addPrice(int applesPrice), чтобы при его вызове суммарная стоимость яблок увеличивалось на переданное значение.
За суммарную стоимость яблок отвечает переменная public static int applesPrice.
*/
public class Test
{

    public static void main(String[] args) {
        Apple apple = new Apple();
        Apple.addPrice(50);
        Apple apple2 = new Apple();
        Apple.addPrice(100);
        System.out.println("Apples price is " + Apple.applesPrice);
    }

    public static class Apple{
        public static int applesPrice = 0;

        public static void addPrice(int applesPrice){
            Apple.applesPrice += applesPrice;
            //напишите тут ваш код
        }
    }


    }

