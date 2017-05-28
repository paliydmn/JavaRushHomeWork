package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Dima on 17.02.2016.
 */

public class MoldovanHen extends Hen
{
    @Override
    public String getDescription()
    {
        Hen hen = new MoldovanHen();
        return (super.getDescription() +  " Моя страна - " + Country.MOLDOVA + ". Я несу " + hen.getCountOfEggsPerMonth() +" яиц в месяц.");
    }
    @Override
    public int getCountOfEggsPerMonth()
    {
        return 300;
    }
}
