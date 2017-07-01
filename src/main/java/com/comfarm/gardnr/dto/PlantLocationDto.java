package com.comfarm.gardnr.dto;

import lombok.Data;

@Data
public class PlantLocationDto {
    /**
     * possible values
     *
     * [
     * backyard
     * balcony
     * indoors
     * rooftop
     * ]
     */
    private String name;
}
