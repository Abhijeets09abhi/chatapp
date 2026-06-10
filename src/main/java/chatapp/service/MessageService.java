package chatapp.service;

import chatapp.entity.Message;
import chatapp.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    // SAVE MESSAGE
    public void saveMessage(Message message) {

        System.out.println("Saving message...");

        messageRepository.save(message);

        System.out.println("Message saved!");
    }

    // GET CHAT HISTORY
    public List<Message> getMessages(
            String sender,
            String receiver) {

        List<Message> chat =
                new ArrayList<>();

        chat.addAll(
                messageRepository
                        .findBySenderAndReceiver(
                                sender,
                                receiver));

        chat.addAll(
                messageRepository
                        .findByReceiverAndSender(
                                sender,
                                receiver));

        return chat;
    }
}
