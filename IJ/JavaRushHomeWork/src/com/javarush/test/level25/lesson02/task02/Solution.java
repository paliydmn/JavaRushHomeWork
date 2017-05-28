package com.javarush.test.level25.lesson02.task02;

import java.util.ArrayList;
import java.util.List;

/* Машину на СТО не повезем!
Инициализируйте поле wheels используя данные из loadWheelNamesFromDB.
Обработайте некорректные данные.
Подсказка: если что-то не то с колесами, то это не машина!
Сигнатуры не менять.
*/
public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() {
            //init wheels here
            wheels = new ArrayList<>();
            String[] arr = loadWheelNamesFromDB();

            Wheel[] arrWh = Wheel.values();
            for (Wheel wh : arrWh)
            for (String st : arr)
            {
                if(wh == Wheel.valueOf(st))
                    wheels.add(Wheel.valueOf(st));
            }

        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args)
    {
        Car car = new Car();

        System.out.println(car.wheels);
    }
}
