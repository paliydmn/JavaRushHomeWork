package com.javarush.test.level22.lesson05.task01;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
Метод main не участвует в тестировании.
*/
public class Solution {

    public static String getPartOfString(String string)throws TooShortStringException
    {
        StringBuffer sb = new StringBuffer();
        try{
            String[] temp = string.split(" ");
            for (int i = 1; i <= 4; i++)
            {
                 sb.append(temp[i]);
                if(i < 4)
                 sb.append(" ");
            }
        }
        catch (Exception e){
            throw new TooShortStringException();
        }
        return sb.toString();
    }

    public static class TooShortStringException extends Throwable
    {

    }

    public static void main(String[] args) throws TooShortStringException
    {
        System.out.println(getPartOfString("JavaRush -  ava."));

    }
  }
