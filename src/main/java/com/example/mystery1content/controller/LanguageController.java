package com.example.mystery1content.controller;

import com.example.mystery1content.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LanguageController {
    @Autowired
    private LanguageService languageService;

    @PostMapping("/CheckLanguage")
    public String setTagLanguage(@RequestBody String tag) {
        return languageService.checkTag(tag);
    }
}
