package com.example.example4sem6_rikky_and_morty_rest.controller;

import com.example.example4sem6_rikky_and_morty_rest.domain.Characters;
import com.example.example4sem6_rikky_and_morty_rest.properties.Params;
import com.example.example4sem6_rikky_and_morty_rest.service.ServiceApi;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        if (ID < allCharacters.getInfo().getPages()){
            ID++;
            String id = String.valueOf(ID);
            allCharacters = serviceApi.getAllCharacters(param.getCHARACTER_API() + "/?page=" + id);
            System.out.println(param.getCHARACTER_API() + "/?id=" + id);
            model.addAttribute("characters", allCharacters.getResults());
        } else {
            String id = String.valueOf(ID);
            allCharacters = serviceApi.getAllCharacters(param.getCHARACTER_API() + "/?page=" + id);
            System.out.println(param.getCHARACTER_API() + "/?id=" + id);
            model.addAttribute("characters", allCharacters.getResults());
        }
        return "index";

    }

    @GetMapping("/pages/previous")
    public String showPreviousPages(Model model) {
        if (ID > 1){
            ID--;
            String id = String.valueOf(ID);
            Characters allCharacters = serviceApi.getAllCharacters(param.getCHARACTER_API() + "/?page=" + id);
            System.out.println(param.getCHARACTER_API() + "/?id=" + id);
            model.addAttribute("characters", allCharacters.getResults());
        } else {
            String id = String.valueOf(ID);
            Characters allCharacters = serviceApi.getAllCharacters(param.getCHARACTER_API() + "/?page=" + id);
            System.out.println(param.getCHARACTER_API() + "/?id=" + id);
            model.addAttribute("characters", allCharacters.getResults());
        }
        return "index";
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
