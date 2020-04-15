package AutoBoxing;

import java.io.*;
import java.util.*;

public class BoxUnbox {

    public static void main(String arg[]){
        Integer integer=new Integer(10);
        int number=integer;

        System.out.println(">>>>>>>>>>>>>>>>>");
        System.out.println(">>>>>>>>>"+integer);
        System.out.println(">>>>>>>>>>>>>>>>>");
        System.out.println(">>>>>>>>>"+number);
        System.out.println(">>>>>>>>>>>>>>>>>");

        List<Integer> list =new ArrayList<Integer>();

        for(int i=0;i<number;i++){
            list.add(i);
            System.out.println(">>>>>>>>>"+list.get(i));
        }
    }
}
