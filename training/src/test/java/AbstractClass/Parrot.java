package AbstractClass;

public class Parrot extends Bird {

    public Parrot(String name){
        super(name);
    }

    @Override
    public void eat() {
        System.out.println("Parrot eat");
    }

    @Override
    public void breath() {
        System.out.println("Parrot breath");
    }

}
