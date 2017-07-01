package com.comfarm.gardnr.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class NewSurveyDto {

    private String experienced;
    private List<PlantTypeDto> plantType=new ArrayList<>();
    private List<PlantLocationDto> plantLocation=new ArrayList<>();

}
