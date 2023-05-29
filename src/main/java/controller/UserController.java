package controller;

import org.springframework.ui.Model;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.UserService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/user")
    public String home(Model model) {

        List<Void> userList = userService.userList();
        model.addAttribute("userList" , userList);
        return "index";
    }



}
