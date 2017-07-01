package com.comfarm.gardnr.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.sql.Date;

public class BaseDomain {

    @CreatedDate
    private Date createdAt;


    @LastModifiedDate
    private Date updatedAt;
}
