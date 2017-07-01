package com.comfarm.gardnr.dto;

import lombok.Data;

@Data
public class PlantTypeDto {
    //acceptable values are
    /**
     * fruits
     * herbs
     * house
     * succulent
     * vegetable
     */
    private String name;
}
