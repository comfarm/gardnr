package com.comfarm.gardnr.mapper;

import com.comfarm.gardnr.domain.User;
import com.comfarm.gardnr.dto.UserDto;
import org.modelmapper.AbstractConverter;

public class UserDomainToDto extends AbstractConverter<User, UserDto>{
    @Override
    protected UserDto convert(User domain) {
        UserDto dto=new UserDto();
        dto.setUsername(domain.getUsername());
        dto.setPassword(domain.getPassword());
        dto.setFirstname(domain.getFirstname());
        dto.setLastname(domain.getLastname());
        dto.setLatitude(domain.getLatitude());
        dto.setLongitude(domain.getLongitude());
        dto.setAddress(domain.getAddress());
        dto.setToken(domain.getToken());
        return dto;
    }
}
