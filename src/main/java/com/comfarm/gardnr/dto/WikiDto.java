package com.comfarm.gardnr.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class WikiDto extends NewWikiDto{

    @JsonProperty("id")
    private Long id;

}
