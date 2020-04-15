package AutoBoxing;

import java.io.*;
import java.util.*;

public class BoxUnbox3 {

    public static int sumOfOddNumber(List<Integer> list)
    {
        int sum = 0;
        for (Integer i : list)
        {
            // unboxing of i automatically
            if(i % 2 != 0)
                sum += i;
            /* unboxing of i is done automatically
               using intvalue implicitly
            if(i.intValue() % 2 != 0)
                sum += i.intValue();*/
        }
        return sum;
    }

    public static void main (String[] args)
    {
        /* Here we are creating a list of elements
           of Integer type and adding the int primitives
           type values to the list*/
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++)
            list.add(i);

        // getting sum of all odd no. in the list.
        int sumOdd = sumOfOddNumber(list);
        System.out.println("Sum of odd numbers = " + sumOdd);
    }

}
