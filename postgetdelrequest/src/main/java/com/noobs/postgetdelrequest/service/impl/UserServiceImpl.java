package com.noobs.postgetdelrequest.service.impl;

import com.noobs.postgetdelrequest.converter.UserConverter;
import com.noobs.postgetdelrequest.dto.UserRegisterRequest;
import com.noobs.postgetdelrequest.dto.UserResponse;
import com.noobs.postgetdelrequest.entity.User;
import com.noobs.postgetdelrequest.repository.UserRepository;
import com.noobs.postgetdelrequest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private  final UserRepository userRepository;
    private final UserConverter userConverter;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserConverter userConverter) {
        this.userRepository = userRepository;
        this.userConverter = userConverter;
    }

    @Override
    public UserResponse saveUser(UserRegisterRequest request) {
        User user = userConverter.toUser(request);

        User userSaved = userRepository.save(user);

        return userConverter.toResponse(userSaved);
    }

    @Override
    public UserResponse getUser(Long id) {
        User user = userRepository.findById(id).orElse(new User());
        return userConverter.toResponse(user);
    }

    @Override
    public void deletedUser(Long id) {
        userRepository.deleteById(id);
    }
}
