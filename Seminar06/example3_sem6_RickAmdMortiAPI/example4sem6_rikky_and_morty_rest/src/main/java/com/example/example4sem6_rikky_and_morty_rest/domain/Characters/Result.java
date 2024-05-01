package com.example.example4sem6_rikky_and_morty_rest.domain.Characters;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;

@Data
public class Result {
    private Integer id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    private String image;
    private String url;
    private Date created;

    public Origin origin;
    public ArrayList<String> episode;


}
