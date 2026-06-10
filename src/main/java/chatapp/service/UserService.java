package chatapp.service;

import chatapp.entity.User;
import chatapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // FOR REGISTRATION
    public void saveUser(User user) {
        userRepository.save(user);
    }

    // FOR LOGIN
    public User login(String email, String password) {

        User user = userRepository.findByEmail(email);

        if (user != null &&
                user.getPassword().equals(password)) {

            return user;
        }

        return null;
    }
}
