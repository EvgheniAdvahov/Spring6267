package com.example.example4sem6_rikky_and_morty_rest.controller;

import com.example.example4sem6_rikky_and_morty_rest.domain.Characters.Characters;
import com.example.example4sem6_rikky_and_morty_rest.domain.Characters.Result;
import com.example.example4sem6_rikky_and_morty_rest.properties.Params;
import com.example.example4sem6_rikky_and_morty_rest.service.ServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class ControllerAPI {

    private static int ID = 1;
    @Autowired
    private ServiceApi serviceApi;
    @Autowired
    private Params param;

    @GetMapping("/")
    public String showMainPage(Model model) {
        ID = 1;
        Characters allCharacters = serviceApi.getAllCharacters(param.getCHARACTER_API());
        System.out.println(param.getCHARACTER_API());
        model.addAttribute("characters", allCharacters.getResults());
        return "index";
    }

    @GetMapping("/pages/next")
    public String showNextPages(Model model) {
        Characters allCharacters = serviceApi.getAllCharacters(param.getCHARACTER_API());
        if (ID < allCharacters.getInfo().getPages()) {
            ID++;
            String id = String.valueOf(ID);
            allCharacters = serviceApi.getAllCharacters(param.getCHARACTER_API() + "/?page=" + id);
            System.out.println(param.getCHARACTER_API() + "/?id=" + id);
            model.addAttribute("characters", allCharacters.getResults());
        } else {
            String id = String.valueOf(ID);
            allCharacters = serviceApi.getAllCharacters(param.getCHARACTER_API() + "/?page=" + id);
            System.out.println(param.getCHARACTER_API() + "?id=" + id);
            model.addAttribute("characters", allCharacters.getResults());
        }
        return "index";

    }

    @GetMapping("/pages/previous")
    public String showPreviousPages(Model model) {
        if (ID > 1) {
            ID--;
            String id = String.valueOf(ID);
            Characters allCharacters = serviceApi.getAllCharacters(param.getCHARACTER_API() + "/?page=" + id);
            System.out.println(param.getCHARACTER_API() + "?id=" + id);
            model.addAttribute("characters", allCharacters.getResults());
        } else {
            String id = String.valueOf(ID);
            Characters allCharacters = serviceApi.getAllCharacters(param.getCHARACTER_API() + "/?page=" + id);
            System.out.println(param.getCHARACTER_API() + "/?id=" + id);
            model.addAttribute("characters", allCharacters.getResults());
        }
        return "index";
    }

    @GetMapping("personal/{id}")
    public String showCaracterInfo(@PathVariable String id, Model model) {
        Result character = serviceApi.getCharacterInfo(param.getCHARACTER_API()+id);
        System.out.println(character.getName());
        model.addAttribute("caracterInfo", character);
        return "characterinfo";
    }


//    @GetMapping("/pages")
//    public String showAllPages(@RequestParam String id, Model model) {
//        Characters allCharacters = serviceApi.getAllCharacters(param.getCHARACTER_API() + "/?page=" + id);
//        System.out.println(param.getCHARACTER_API() + "/?id=" + id);
//        model.addAttribute("characters", allCharacters.getResults());
//        return "index";
//    }

//    @GetMapping("/")
//    public ResponseEntity<Characters> getCharacters()
//    {
//        Characters allCharacters = serviceApi.getAllCharacters();
//        return new ResponseEntity<>(allCharacters, HttpStatus.OK);
//    }


}
