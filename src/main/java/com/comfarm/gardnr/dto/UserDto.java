package com.comfarm.gardnr.dto;

import lombok.Data;

/**
 * Created by Admin on 7/1/2017.
 */
@Data
public class UserDto {
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String longitude;
    private String latitude;
    private String address;
    private String token;
}
