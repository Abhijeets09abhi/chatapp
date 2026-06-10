package chatapp.repository;

import chatapp.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository
        extends JpaRepository<Message, Long> {
}
