package com.example.example4sem6_rikky_and_morty_rest.controller;

import com.example.example4sem6_rikky_and_morty_rest.domain.Characters;
import com.example.example4sem6_rikky_and_morty_rest.service.ServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping()
public class ControllerAPI {
    @Autowired
    private ServiceApi serviceApi;

    @GetMapping("/")
    public String showMainPage() {
        Characters allCharacters = serviceApi.getAllCharacters();
        System.out.println(allCharacters.getInfo());
        System.out.println(allCharacters.getResults());
        return "index";
    }

//    @GetMapping("/")
//    public ResponseEntity<Characters> getCharacters()
//    {
//        Characters allCharacters = serviceApi.getAllCharacters();
//        System.out.println(allCharacters.getInfo());
//        System.out.println(allCharacters.getResults());
//        return new ResponseEntity<>(allCharacters, HttpStatus.OK);
//    }





}
