package chatapp.controller;

import chatapp.entity.User;
import chatapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/chat")
    public String chat() {
        return "chat";
    }

    @PostMapping("/register")
    public String saveUser(
            @RequestParam String username,
            @RequestParam String email,
            @RequestParam String password) {

        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);

        userService.saveUser(user);

        return "redirect:/";
    }
}