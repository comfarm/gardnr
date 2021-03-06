package com.comfarm.gardnr.dto;

import lombok.Data;

import java.util.Date;

@Data
public class PlantDto extends StartPlantDto {

    private long id;
    private Date createdAt;
    private Date updatedAt;
}
