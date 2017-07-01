package com.comfarm.gardnr.controller;

import com.comfarm.gardnr.domain.User;
import com.comfarm.gardnr.dto.UserDto;
import com.comfarm.gardnr.service.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UserController implements UserApi {
    @Autowired
    private UserService userService;

    @Override
    public ResponseEntity<UserDto> saveUser(@RequestBody UserDto request, BindingResult bindingResult) {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        User user = mapper.map(request, User.class);
        User saved = userService.saveUser(user);
        UserDto dto = mapper.map(saved, UserDto.class);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<UserDto> getUser(String user) {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        User saved = userService.getUser(user);
        UserDto dto = mapper.map(saved, UserDto.class);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
}
