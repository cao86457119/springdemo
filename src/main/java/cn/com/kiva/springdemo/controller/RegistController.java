package cn.com.kiva.springdemo.controller;

import cn.com.kiva.springdemo.model.User;
import cn.com.kiva.springdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistController {
    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Autowired
    UserService userService;
    @PostMapping("/regist")
    public String regist(@RequestParam String username,@RequestParam String pwd){
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(pwd));
        userService.insert(user);
        return "sucess";
    }

    @GetMapping("/regist")
    public String regist(){
        return "regist";
    }
}
