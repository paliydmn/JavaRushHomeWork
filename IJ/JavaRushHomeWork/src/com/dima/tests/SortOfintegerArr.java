package com.dima.tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Dima on 11.07.2016.
 */
public class SortOfintegerArr
{
    public static void main(String[] args)
    {
       /* int[] ints = new int[]{23,34,45,657,21,1,2,3,46,76,90,0,12,45,45,45,45,45};
        Arrays.sort(ints);
        for (int i : ints)
            System.out.println(i);*/

        List<String> list = new ArrayList<String>(Arrays.asList("as","aSDE", "BVC", "yur", "zzz"));


        Collections.sort(list,Collections.<String>reverseOrder());
        for (String l : list)
            System.out.println(l);

    }
}
