package com.example.example4sem6_rikky_and_morty_rest.service;

import com.example.example4sem6_rikky_and_morty_rest.domain.Characters.Characters;
import com.example.example4sem6_rikky_and_morty_rest.domain.Characters.Result;

public interface ServiceApi {

    public Characters getAllCharacters(String param);

    public Result getCharacterInfo(String param);
}
