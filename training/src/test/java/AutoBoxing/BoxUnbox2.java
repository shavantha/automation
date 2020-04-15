package AutoBoxing;

import java.io.*;

import java.util.*;

public class BoxUnbox2 {

    public static void main(String[] arg) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {

            list.add(Integer.valueOf(i));

            System.out.println(">>>>>>>>>>>"+list.get(i));
        }
    }
}
