package com.example.example4sem6_rikky_and_morty_rest.controller;

import com.example.example4sem6_rikky_and_morty_rest.domain.Characters;
import com.example.example4sem6_rikky_and_morty_rest.properties.Params;
import com.example.example4sem6_rikky_and_morty_rest.service.ServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping()
public class ControllerAPI {
    @Autowired
    private ServiceApi serviceApi;
    @Autowired
    private Params param;

    @GetMapping("/")
    public String showMainPage(Model model) {
        Characters allCharacters = serviceApi.getAllCharacters(param.getCHARACTER_API());
//        "https://rickandmortyapi.com/api/character"+id
        System.out.println(allCharacters.getInfo());
        System.out.println(allCharacters.getResults());
        model.addAttribute("characters", allCharacters.getResults());
        return "index";
    }

    @GetMapping("/pages")
    public String showAllPages(Model model, @RequestParam int id){
        Characters allCharacters = serviceApi.getAllCharacters(param.getCHARACTER_API());
        System.out.println(param.getCHARACTER_API());
        System.out.println(allCharacters.getInfo().getPages());
        model.addAttribute("characters", allCharacters.getResults());
        return "index";
    }

//    @GetMapping("/")
//    public ResponseEntity<Characters> getCharacters()
//    {
//        Characters allCharacters = serviceApi.getAllCharacters();
//        return new ResponseEntity<>(allCharacters, HttpStatus.OK);
//    }





}
