package com.javarush.test.level21.lesson05.task01;

import java.util.HashSet;
import java.util.Set;

/* Equals and HashCode
В классе Solution исправить пару методов equals/hashCode в соответствии с правилами реализации этих методов.
Метод main не участвует в тестировании.
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }
    @Override
    public boolean equals(Object o) {

        Solution os = (Solution) o;
        return (o == null || o.getClass() != this.getClass()) ? false : ((this.first == os.first && this.last == os.last) ? true : false);
    }
    @Override
    public int hashCode() {

        if(first == null || last == null)
            return 0;

        return  31* (first.hashCode() + last.hashCode());

    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();


        s.add(new Solution("1", null));


        for (Solution sl : s)
            System.out.println(sl.hashCode());

        System.out.println(s.contains(new Solution("1",null)));
    }
}
