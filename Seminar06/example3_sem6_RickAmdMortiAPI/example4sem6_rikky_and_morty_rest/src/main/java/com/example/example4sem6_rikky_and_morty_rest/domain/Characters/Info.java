package com.example.example4sem6_rikky_and_morty_rest.domain.Characters;

import lombok.Data;

@Data
public class Info {
    private Integer count;
    private Integer pages;
    private String next;
    private String prev;
}
