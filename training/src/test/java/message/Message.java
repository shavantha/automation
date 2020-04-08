package message;

public class Message {
    private String message="";
    private String id="";


    public String getMessage(){
        return message;
    }

    public void setMessage(String message){
        this.message=message;
    }

    public String getID(){
        return id;
    }

    public void setID(String id){
        this.id=id;
    }
}
