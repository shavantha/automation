package student;

public class Student {

    String name;
    String batch;
    int rollNumber;

    public Student(String name, String batch, int rollNumber) {
        this.name=name;
        this.batch=batch;
        this.rollNumber=rollNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public Integer getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(Integer rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String toString(){
        return "The Student name is " + this.name + " studies in Batch " + this.batch + "and has rollNumber " + this.rollNumber;
    }

}