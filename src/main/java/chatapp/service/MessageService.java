package chatapp.service;

import chatapp.entity.Message;
import chatapp.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public void saveMessage(Message message) {

        System.out.println("Saving message...");

        messageRepository.save(message);

        System.out.println("Message saved!");
    }
}
