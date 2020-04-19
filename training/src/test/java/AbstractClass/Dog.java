package AbstractClass;

import org.apache.poi.util.SystemOutLogger;

public class Dog extends Animal {

    public Dog(String name){
        super(name);
    }

    @Override
    public void eat(){
        System.out.println("Dog\t"+getName()+"\teat");
    }

    @Override
    public void breath(){
        System.out.println("Dog\t"+getName()+"\tbreath");
    }
}
