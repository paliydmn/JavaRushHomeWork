package com.javarush.test.level21.lesson16.big01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Dima on 27.06.2016.
 */
public class Hippodrome
{
    public static void main(String[] args) throws InterruptedException, IOException
    {
        game = new Hippodrome();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please set the number of Horses: ");
        int numberOfHorses = Integer.parseInt(reader.readLine());

        for (int i = 0; i<numberOfHorses; i++)
        {
            String hName;
            double hSped;
            //double hDistance;
            System.out.println("Enter the " + i + " Horse name / speed / endurance ");
            hName = reader.readLine();
            hSped = Double.parseDouble(reader.readLine());
            int endur = Integer.parseInt(reader.readLine());

            game.horses.add(new Horse(hName,hSped,0, endur));

        }

       // String hName = reader.readLine();
       /* Horse horse1 = new Horse("horse-1", 3, 0);
        Horse horse2 = new Horse("horse-2", 3, 0);
        Horse horse3 = new Horse("horse-3", 3, 0);

        game.horses.add(horse1);
        game.horses.add(horse2);
        game.horses.add(horse3);*/

        game.run();
        game.printWinner();
    }

    public static Hippodrome game;

    static ArrayList<Horse> horses = new ArrayList<Horse>();

    public ArrayList<Horse> getHorses()
    {
        return horses;
    }

    public void run() throws InterruptedException
    {
        for (int i =0; i < 200; i++)
        {
            move();
            print();
            Thread.sleep(200);

        }

    }
    public void print(){

        for (int i = 0; i < horses.size(); i++)
            horses.get(i).print();
            System.out.println();
            System.out.println();

    }
    public void move(){

        for (int i = 0; i < horses.size(); i++)
            horses.get(i).move();
    }
    public Horse getWinner(){
        Horse winHorse = null;

        double maxDist = 0;
        String winner = null;
        for (int i = 0; i < horses.size(); i++)
        {
            if (maxDist < horses.get(i).getDistance())
            {
                maxDist = horses.get(i).getDistance();
                winner = horses.get(i).getName();
            }
        }
        for (Horse h : horses)
        if(h.getName().equals(winner))
            winHorse = h;

        return winHorse;
    }
    public void printWinner(){
        System.out.println("Winner is " + getWinner().getName() + "!");
    }
}
