package com.javarush.test.level22.lesson13.task03;

import java.io.File;
import java.nio.charset.Charset;

/* Проверка номера телефона
Метод checkTelNumber должен проверять, является ли аргумент telNumber валидным номером телефона.
Критерии валидности:
1) если номер начинается с '+', то он содержит 12 цифр
2) если номер начинается с цифры или открывающей скобки, то он содержит 10 цифр
3) может содержать 0-2 знаков '-', которые не могут идти подряд
4) может содержать 1 пару скобок '(' и ')'  , причем если она есть, то она расположена левее знаков '-'
5) скобки внутри содержат четко 3 цифры
6) номер не содержит букв
7) номер заканчивается на цифру

Примеры:
+380501234567 - true
+38(050)1234567 - true
+38050123-45-67 - true
050123-4567 - true

+38)050(1234567 - false
+38(050)1-23-45-6-7 - false
050ххх4567 - false
050123456 - false
(0)501234567 - false
*/
public class Solution {

    public static boolean checkTelNumber(String telNumber) {

        boolean is = false;
        // проверка на null
        if (telNumber == null)
        {
            return false;
        }
        // проверка на состав и окончание
        //ограничиваем состав: отсекаем все, что содержит нецифры, нескобки и не минус, а также проверка на окончание цифрой;
        if (!telNumber.matches("[\\d, \\+,\\(,\\),-]+[\\d]$"))
        {
            return false;
        }

        // проверка - на начальный символ и количество цифирь
        if (telNumber.matches("^\\+.*")) { //если начинается с + - считаем цифири
            String tmp = telNumber.replaceAll("\\D", "");
            if (tmp.length() != 12) {

                return false;
            }
        }
        else if (telNumber.matches("^(\\(|\\d).*")) { //если начинается с "(" или цифры - считаем цифири
            String tmp = telNumber.replaceAll("\\D", "");
            if (tmp.length() != 10) {

                return false;
            }
        }
        // возвращаем false если ничего из вышеперечисленного не подошло и номер не начинается с "-"
        // цифры для номера, начинающегося с "-" не считаю, т.к в условии не известно, сколько их.
        else if (!telNumber.matches("^\\-.*"))
        {
            return false;
        }

        // сюда поступает только номер с нормальным началом, окончанием и количеством цифр.
        //Здесь будем разбираться с внутренностями.
        if (telNumber.matches("\\+?\\d*(\\(\\d{3}\\))?\\d+-?\\d+-?\\d*")) {
            is = true;
        }
        return is;

    }

    public static void main(String[] args)
    {
        Charset charset = Charset.defaultCharset();
        System.out.println(charset);
        File myDir = new File("D:\\javaTests");
        myDir.mkdir();

        if(myDir.exists())
        {
            System.out.println(true + " " + myDir.toString().split("\\\\")[myDir.toString().split("\\\\").length-1]);
        }

    }
}
