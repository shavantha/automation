package message;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.sql.SQLOutput;

public class FinalMessage {

    public static void main(String arg[])throws JsonProcessingException {

        Message message = new Message();
        message.setMessage("hi shavantha");
        message.setID("1");


    }
}
