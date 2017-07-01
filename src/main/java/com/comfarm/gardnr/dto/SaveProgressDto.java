package com.comfarm.gardnr.dto;

import lombok.Data;

import java.util.Date;

@Data
public class SaveProgressDto {

    private Long tanimId;
    private String image;
    private String content;
    private Date progressDate;
    private String title;

}
