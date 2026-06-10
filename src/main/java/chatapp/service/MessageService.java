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

        System.out.println("Sender = " + sender);
        System.out.println("Receiver = " + receiver);

        List<Message> chat = new ArrayList<>();

        List<Message> sent =
                messageRepository.findBySenderAndReceiver(
                        sender,
                        receiver);

        List<Message> received =
                messageRepository.findByReceiverAndSender(
                        sender,
                        receiver);

        System.out.println("Sent Messages = " + sent.size());
        System.out.println("Received Messages = " + received.size());

        chat.addAll(sent);
        chat.addAll(received);

        return chat;
    }
}
