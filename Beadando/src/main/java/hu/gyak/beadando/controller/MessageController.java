package hu.gyak.beadando.controller;

import hu.gyak.beadando.entity.Message;
import hu.gyak.beadando.entity.User;
import hu.gyak.beadando.repository.MessageRepository;
import hu.gyak.beadando.repository.UserRepository;
import hu.gyak.beadando.service.CustomUserDetailsService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
public class MessageController {
    private final UserRepository userRepository;
    private final MessageRepository messageRepository;

    public MessageController(UserRepository ur, MessageRepository msgr) {
        this.userRepository = ur;
        this.messageRepository = msgr;
    }

    @GetMapping("/contact")
    public String contactPage() {
        return "contact";
    }

    @GetMapping("/messages")
    public String messagesPage(Model model, Authentication authentication) {
        User user = userRepository.findByUsername(authentication.getName()).orElseThrow();
        model.addAttribute("messages", messageRepository.findByUserIdOrderByDateTimeDesc(user.getId()));
        return "messages";
    }

    @PostMapping("/contact")
    public String contact(@RequestParam String username, @RequestParam String subject, @RequestParam String content, Model model) {
        User user = userRepository.findByUsername(username).orElse(null);
        if (user == null) {
            model.addAttribute("error", "No user found with the name \"" + username + "\"");
            return "contact";
        }
        if (content.isBlank()) {
            model.addAttribute("error", "Message has no content");
            return "contact";
        }
        if(subject.isBlank()){
            subject = null;
        }

        Message msg = new Message();
        msg.setUser(user);
        msg.setSubject(subject);
        msg.setContent(content);
        msg.setDateTime(LocalDateTime.now());
        messageRepository.save(msg);

        return "redirect:/contact?messageSent";
    }

}
