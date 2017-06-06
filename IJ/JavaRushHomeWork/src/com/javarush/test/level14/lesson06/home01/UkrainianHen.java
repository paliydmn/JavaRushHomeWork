package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Dima on 17.02.2016.
 */
public class UkrainianHen extends Hen
{
    @Override
    public String getDescription()
    {
        Hen hen = new UkrainianHen();
        return (super.getDescription() +  " Моя страна - " + Country.UKRAINE + ". Я несу " + hen.getCountOfEggsPerMonth() +" яиц в месяц.");
    }
    @Override
    public int getCountOfEggsPerMonth()
    {
        return 890;
    }
}


