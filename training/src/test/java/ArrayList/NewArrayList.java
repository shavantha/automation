package ArrayList;

import java.util.ArrayList;
import java.util.Iterator;

public class NewArrayList {

    public static void main(String[] args) {

        String str="";
        ArrayList<String> list = new ArrayList<>(5);
        list.add("Shavantha");
        list.add("Chamila");
        list.add("Chenaya");


        Iterator<String> iterator =list.iterator();

        while (iterator.hasNext()){
             str=iterator.next();
            System.out.println(">>>>>>"+str.toUpperCase());
        }

        if(list.get(2)!=null){
            list.add("Nimal");
            str=list.get(3);
            System.out.println(">>>>>>"+str.toUpperCase());
        }else {
            System.out.println("Already added");
        }


    }

}
