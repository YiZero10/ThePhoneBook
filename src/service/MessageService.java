package service;

import model.Message;

import java.util.List;

public interface MessageService {

    boolean addMessage(Message message);

    List<Message> getMessageByName(String name);

    List<Message> getMessageByType(int type);

    List<Message> getAllMessage();

    boolean updateMessage(String name,int key,String value);

    boolean deleteMessage(String phoneNum);

}
