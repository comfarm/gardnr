package com.comfarm.gardnr.service;

import com.comfarm.gardnr.domain.User;
import com.comfarm.gardnr.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User saveUser(User newUser) {
        User user = userRepository.findByUsername(newUser.getUsername());
        if (user == null) {
            userRepository.save(newUser);
            user = userRepository.findByUsername(newUser.getUsername());
        }
        return user;
    }

    public User getUser(String user) {
        User userd =  userRepository.findByUsername(user);
        return userd;
    }
}
