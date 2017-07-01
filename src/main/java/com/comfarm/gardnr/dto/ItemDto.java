package com.comfarm.gardnr.dto;

import lombok.Data;

@Data
public class ItemDto {

    private String category;
    private String name;
    private String description;
    private String icon;
    private Long id;
}
