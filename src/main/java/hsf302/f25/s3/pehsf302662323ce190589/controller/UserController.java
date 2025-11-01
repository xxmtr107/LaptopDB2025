package hsf302.f25.s3.pehsf302662323ce190589.controller;

import hsf302.f25.s3.pehsf302662323ce190589.entity.User;
import hsf302.f25.s3.pehsf302662323ce190589.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping({"/login", "/"})
    public String showLogin(){
        return "login";
    }

    @GetMapping("/logout")
    public String doLogout(HttpSession session){
        session.invalidate();
        return "redirect:/login";
    }

    @PostMapping("/auth")
    public String doLogin(@RequestParam  String email,
                          @RequestParam String password,
                          HttpSession session){
        User user = userService.authenticate(email, password);
        if(user == null){
            return "error";
        }
        session.setAttribute("user", user);
        return "redirect:/computers";
    }
}
