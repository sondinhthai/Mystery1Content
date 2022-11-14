package com.example.mystery1content.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @GetMapping("/JeffTheKiller")
    public String jeffTheKiller(){
        return "JeffTheKiller";
    }

    @GetMapping("/ElisaLam")
    public String elisaLam(){
        return "ElisaLam";
    }

    @GetMapping("/InunakiVillage")
    public String inunakiVillage(){
        return "InunakiVillage";
    }
}
