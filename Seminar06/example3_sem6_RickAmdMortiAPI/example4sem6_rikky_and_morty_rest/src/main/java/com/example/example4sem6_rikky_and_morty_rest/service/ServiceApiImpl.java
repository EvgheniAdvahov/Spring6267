package com.example.example4sem6_rikky_and_morty_rest.service;

import com.example.example4sem6_rikky_and_morty_rest.domain.Characters.Characters;
import com.example.example4sem6_rikky_and_morty_rest.domain.Characters.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ServiceApiImpl implements ServiceApi {

    @Autowired
    private RestTemplate template;

    @Autowired
    private HttpHeaders headers;

    @Override
    public Characters getAllCharacters(String param) {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Characters> responce = template.exchange(param, HttpMethod.GET, entity, Characters.class);

        return responce.getBody();
    }

    @Override
    public Result getCharacterInfo(String param) {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Result> responce = template.exchange(param, HttpMethod.GET, entity, Result.class);
        return responce.getBody();

    }

//    @Override
//    public PersonalCharacter getCharacterInfo(String param) {
//        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
//        HttpEntity<String> entity = new HttpEntity<>(headers);
//        ResponseEntity<PersonalCharacter> responce = template.exchange(param, HttpMethod.GET, entity, PersonalCharacter.class);
//        return responce.getBody();
//
//    }

}
