package com.comfarm.gardnr.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class MilestoneDto {
    private String image;
    private String content;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date;
    private String title;

    private int dayNum;
}
