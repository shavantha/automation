package AbstractClass;

public class Penguin extends Bird {

    public Penguin(String name){
        super(name);
    }

    @Override
    public void breath() {
        System.out.println("penguin can breath");
    }

    @Override
    public void eat() {
        System.out.println("Penguin can breath");
    }

    @Override
    public void fly() {
        System.out.println("Penguins cant fly");
    }
}
