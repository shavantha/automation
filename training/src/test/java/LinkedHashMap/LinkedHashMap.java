package LinkedHashMap;

import java.util.*;
class LinkedHashMap1{
    public static void main(String args[]){

        LinkedHashMap<Integer,String> linkedHashMap=new LinkedHashMap<Integer,String>(5);

        linkedHashMap.put(100,"Shavantha");
        linkedHashMap.put(101,"Vijay");
        linkedHashMap.put(102,"Rahul");
        linkedHashMap.put(103,"Amit");
        linkedHashMap.put(104,"Malik");
        linkedHashMap.put(105,"Kumara");

        System.out.println("The LinkedHashMap contains key"+linkedHashMap.keySet());

            while (linkedHashMap.containsKey(102)){
                System.out.println("The matching value is found :"+linkedHashMap.get(102));
              break;
            }


    }
} 