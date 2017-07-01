package com.comfarm.gardnr.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class StartPlant {

    private Long userId;
    private Long wikiId;
    private Date startDate;
    private Date endDate;
}