package ArrayList;


import java.util.ArrayList;

public class ArrayListClass {

    private ArrayList<String> groceryList = new ArrayList<String>();


        public void addGroceryItem (String item){
            groceryList.add(item);
        }

        public void printGroceryList () {
            System.out.println("You have" + groceryList.size() + "items in your grocery list");
            for (int i = 0; i < groceryList.size(); i++) {
                System.out.println((i + 1) + "." + groceryList.get(i));
            }
        }

        public void modifyGroceryList ( int position, String newItem){
            groceryList.set(position, newItem);
            System.out.println("Grocery items" + (position + 1) + "has been modified");
        }

        public void removeGroceryItem ( int position){
            String item = groceryList.get(position);
            groceryList.remove(item);

        }
    public static void main(String arg[]) {
        ArrayListClass arrayListClass =new ArrayListClass();
        arrayListClass.addGroceryItem("Rice");
        arrayListClass.printGroceryList();
        arrayListClass.modifyGroceryList(0,"dhal");
        arrayListClass.removeGroceryItem(0);
        arrayListClass.printGroceryList();
    }
}
