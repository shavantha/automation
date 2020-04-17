package LinkedList;

import java.util.Iterator;
import java.util.LinkedList;


public class CityList {
    public static void main(String[] args) {
        LinkedList<String> linkedList =new LinkedList<>();
        linkedList.add("Colombo");
        linkedList.add("Kandy");
        linkedList.add("Anuradhapura");

        printList(linkedList);
        linkedList.add(1,"Galle");
        printList(linkedList);
        linkedList.remove(0);
        printList(linkedList);
    }

    public static void printList(LinkedList<String> linkedList){
        Iterator<String> iterator = linkedList.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("================");
    }
}
