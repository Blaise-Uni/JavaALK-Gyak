package hu.gyak.beadando.controller;

import hu.gyak.beadando.entity.User;
import hu.gyak.beadando.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    private final UserRepository userRepository;
    private final PasswordEncoder pwdEncoder;

    public LoginController(UserRepository ur, PasswordEncoder pwdEnc) {
        this.userRepository = ur;
        this.pwdEncoder = pwdEnc;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String pwd, Model model) {
        if (userRepository.findByUsername(username).isPresent()) {
            model.addAttribute("error", "This username is already taken!");
            return "register";
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(pwdEncoder.encode(pwd));
        user.setRole("USER");
        userRepository.save(user);

        return "redirect:/login?registered";
    }
}
