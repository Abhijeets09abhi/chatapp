package chatapp.controller;

import chatapp.entity.Message;
import chatapp.entity.User;
import chatapp.service.MessageService;
import chatapp.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private MessageService messageService;

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

    @PostMapping("/login")
    public String loginUser(
            @RequestParam String email,
            @RequestParam String password) {

        User user = userService.login(email, password);

        if (user != null) {
            return "redirect:/chat";
        }

        return "login";
    }

    @PostMapping("/send")
    @ResponseBody
    public String sendMessage(
            @RequestParam String sender,
            @RequestParam String receiver,
            @RequestParam String message) {

        System.out.println("SEND METHOD CALLED");
        System.out.println(sender);
        System.out.println(receiver);
        System.out.println(message);

        Message msg = new Message();

        msg.setSender(sender);
        msg.setReceiver(receiver);
        msg.setMessage(message);

        messageService.saveMessage(msg);

        return "saved";
    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "HELLO";
    }
}
