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

        System.out.println("EMAIL ENTERED = " + email);

        if(user != null) {
            System.out.println("EMAIL FOUND");
            System.out.println("DB PASSWORD = " + user.getPassword());
            System.out.println("ENTERED PASSWORD = " + password);
        } else {
            System.out.println("EMAIL NOT FOUND");
        }

        if(user != null &&
                user.getPassword().equals(password)) {

            System.out.println("LOGIN SUCCESS");

            return user;
        }

        System.out.println("LOGIN FAILED");

        return null;
    }
    }

