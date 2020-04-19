package AbstractClass;

public  class Bird extends Animal implements CanFly{

    public Bird(String name){
        super(name);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void breath() {
        System.out.println("Dog\t"+getName()+"\teat");
    }

    @Override
    public void eat() {
        System.out.println("Dog\t"+getName()+"\tbreath");
    }

    @Override
    public void fly() {
        System.out.println("Bird can fly");
    }
}
