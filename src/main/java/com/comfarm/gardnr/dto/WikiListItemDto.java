package com.comfarm.gardnr.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WikiListItemDto {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("title")
    private String title;

}
