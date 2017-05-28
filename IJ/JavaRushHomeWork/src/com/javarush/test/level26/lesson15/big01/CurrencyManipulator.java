package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.*;

/**
 * Created by Alex on 28.04.2014.
 */
public class CurrencyManipulator
{

    private String currencyCode;
    private Map<Integer, Integer> denominations = new HashMap<>();

    public boolean isAmountAvailable(int expectedAmount)
    {
        return expectedAmount <= getTotalAmount();
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException
    {
        int sum = expectedAmount;
        HashMap<Integer, Integer> temp = new HashMap<>();
        temp.putAll(denominations);
        ArrayList<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> pair : temp.entrySet())
            list.add(pair.getKey());

        Collections.sort(list);
        Collections.reverse(list);

        TreeMap<Integer, Integer> result = new TreeMap<>(new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                return o2.compareTo(o1);
            }
        });

        for (Integer aList : list) {
            int key = aList;
            int value = temp.get(key);
            while (true) {
                if (sum < key || value <= 0) {
                    temp.put(key, value);
                    break;
                }
                sum -= key;
                value--;

                if (result.containsKey(key))
                    result.put(key, result.get(key) + 1);
                else
                    result.put(key, 1);
            }
        }

        if (sum > 0)
            throw new NotEnoughMoneyException();
        else
        {
            for (Map.Entry<Integer, Integer> pair : result.entrySet())
                ConsoleHelper.writeMessage("\t" + pair.getKey() + " - " + pair.getValue());

            denominations.clear();
            denominations.putAll(temp);
            ConsoleHelper.writeMessage("Transaction was successful!");
        }
        return result;
    }

    public CurrencyManipulator(String currencyCode)
    {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode()
    {
        return currencyCode;
    }

    public void addAmount(int denomination, int count){
        if(denominations.containsKey(denomination))
            denominations.put(denomination, denominations.get(denomination) + count);
        else
            denominations.put(denomination,count);
    }

    public int getTotalAmount(){
        int result = 0;
        for(Map.Entry<Integer,Integer> pair : denominations.entrySet())
            result = result + (pair.getKey() * pair.getValue());

        return result;
    }

    public boolean hasMoney(){
        return denominations.size() != 0;
    }
}
/*
package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

*/
/**
 * Created by Dima on 03.10.2016.
 *//*

public class CurrencyManipulator
{
    private String currencyCode;


    private Map<Integer, Integer> denominations;

    public CurrencyManipulator(String currencyCode)
    {
        this.currencyCode = currencyCode;
        denominations = new HashMap<Integer, Integer>();
    }

    public String getCurrencyCode()
    {
        return currencyCode;
    }

    */
/*
    4. В классе CurrencyManipulator создайте метод void addAmount(int denomination, int count),
который добавит введенные номинал и количество банкнот
     *//*


    public void addAmount(int denomination, int count)
    {
        if (denominations==null)
            denominations = new HashMap<>();
        if (denominations.keySet().contains(denomination))
        {
            denominations.put(denomination,denominations.get(denomination)+count);
        }
        else
            denominations.put(denomination,count);
    }
    public int getTotalAmount()
    {
        int sum=0;
        for (Map.Entry<Integer,Integer> entry: denominations.entrySet())
        {
            sum+=(entry.getKey()*entry.getValue());
        }
        return sum;
    }
    public boolean  hasMoney()
    {
        boolean result=true;
        if (denominations.isEmpty()) result = false;
        else {
            int zerosCount=0;
            for (Map.Entry<Integer,Integer> pair : denominations.entrySet()){
                if (pair.getValue()==0) zerosCount++;
            }
            if (zerosCount==denominations.size()) result=false;
        }
        return result;
    }


*/
/*    public void addAmount(int denomination, int count)
    {
        if (denominations.containsKey(denomination)){
            denominations.put(denomination, denominations.get(denomination) + count);
        }
        else {
            denominations.put(denomination, count);
        }
    }

    public int getTotalAmount()
    {
             int total = 0;
        for (Map.Entry<Integer,Integer> pair : denominations.entrySet())
        {
            int  denom = pair.getKey();
             int count = pair.getValue();
            total += denom*count;

        }
        return total;
    }

    public boolean hasMoney()
    {
        if (denominations.isEmpty())
            return false;
        else return true;
    }

   *//*
*/
/* public boolean isAmountAvailable(int expectedAmount)
    {
        if(getTotalAmount() >= expectedAmount)
        return true;
        else
        return false;
    }*//*


   public boolean isAmountAvailable(int expectedAmount){
       if (expectedAmount <= getTotalAmount()) return true;
       return false;
   }


//Withdraw money

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException
    {
        TreeMap<Integer,Integer> amount = new TreeMap<>(Collections.reverseOrder());
        amount.putAll(denominations);
        Map<Integer,Integer> putAmount;
        int expected;
        while (!amount.isEmpty())
        {
            putAmount = new TreeMap<>(Collections.reverseOrder());
            expected = expectedAmount;
            for (Map.Entry<Integer, Integer> entry : amount.entrySet())
            {
                if (expected / entry.getKey() > 0 && entry.getValue() >= expected / entry.getKey())
                {
                    putAmount.put(entry.getKey(), expected / entry.getKey());
                    expected = expected - entry.getKey() * (int) (expected / entry.getKey());
                }
                else if(expected / entry.getKey() > 0 && entry.getValue() < expected / entry.getKey() && entry.getValue() > 0)
                {
                    putAmount.put(entry.getKey(), entry.getValue());
                    expected = expected - entry.getKey() * entry.getValue();
                }
            }
            if (expected == 0)
            {
                for (Map.Entry<Integer, Integer> entry : putAmount.entrySet())
                    denominations.put(entry.getKey(), denominations.get(entry.getKey()) - entry.getValue());
                return putAmount;
            }
            else{
                if (amount.get(amount.firstKey()) == 0) amount.remove(amount.firstKey());
                if (!amount.isEmpty()) amount.put(amount.firstKey(),amount.get(amount.firstKey())-1);
            }
        }
        throw new NotEnoughMoneyException();
    }


}
*/
