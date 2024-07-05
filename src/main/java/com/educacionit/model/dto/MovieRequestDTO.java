package com.educacionit.model.dto;

import java.util.List;

import lombok.Data;

@Data
public class MovieRequestDTO {
    private String title;
    private String website;
    private String imageurl;
    private List<String> genresNames;
}
