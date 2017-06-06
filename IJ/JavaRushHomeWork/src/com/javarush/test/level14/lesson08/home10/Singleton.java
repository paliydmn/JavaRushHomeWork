package com.javarush.test.level14.lesson08.home10;

/**
 * Created by Dima on 19.02.2016.
 */
public class Singleton
{
        private final static Singleton singleton = new Singleton();
        private Singleton(){}
        public static Singleton getInstance(){return singleton;}
}


