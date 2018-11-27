package cn.com.kiva.springdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/menu")
public class MenuController {
    @GetMapping("/menus")
    public String menus(@RequestParam @NotNull String usercode){
        return "menus";
    }
}
