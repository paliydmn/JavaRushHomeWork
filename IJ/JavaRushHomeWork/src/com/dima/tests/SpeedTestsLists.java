package com.dima.tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Dima on 23.09.2016.
 */
public class SpeedTestsLists
{

    public static void main(String[] args)
    {/*
        LinkedList<String> linkedList = new LinkedList<>();
        int i =0;
        long start = -System.currentTimeMillis();


        while (i < 1500000 )
        {
            linkedList.add((String.format(("just data - %s"),i)));
            i++;
        }
        long end = System.currentTimeMillis();
        System.out.print("LinkedList Adding = ");
        System.out.println(end + start);


        long newStart = -System.nanoTime();
        while (i == 0 )
        {
            linkedList.remove(i);
            i--;
        }
        long newEnd = System.nanoTime();
        System.out.print("Removing = ");
        System.out.println(newEnd + newStart);


//ArrayList
        ArrayList<String> arrayList= new ArrayList<>();
        int j =0;
        long start2 = -System.currentTimeMillis();


        while (j < 1500000 )
        {
            arrayList.add((String.format(("just data - %s"),j)));
            j++;
        }
        long end2 = System.currentTimeMillis();
        System.out.print("ArrayList Adding = ");
        System.out.println(end2 + start2);

        long newStart2 = -System.nanoTime();
        while (j == 0 )
        {
            arrayList.remove(j);
            j--;
        }
        long newEnd2 = System.nanoTime();
        System.out.print("Removing = ");
        System.out.println(newEnd2 + newStart2);

*/
        List<Integer> l = new ArrayList<Integer>();
        l.add(1);
        l = null;
        String s = "test";
        System.out.println("1 " + 2 + 3);



        int[] a = {5,5};
        int b = 1;
        a[b] = b = 0;
        System.out.println(Arrays.toString(a));
    }

}
