package AbstractClass;

public class MainClass {

    public static void main(String[] args) {
        Dog dog = new Dog("Schooby");
        dog.eat();
        dog.breath();

        System.out.println("=================");
        Parrot parrot =new Parrot("Parrot");
        parrot.eat();
        parrot.breath();
        parrot.fly();

        System.out.println("=================");
        Penguin penguin=new Penguin("Penguineee");
        penguin.fly();
        penguin.eat();
        penguin.breath();
    }
}
