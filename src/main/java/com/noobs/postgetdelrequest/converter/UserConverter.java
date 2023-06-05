package com.noobs.postgetdelrequest.converter;

import com.noobs.postgetdelrequest.dto.UserRegisterRequest;
import com.noobs.postgetdelrequest.dto.UserResponse;
import com.noobs.postgetdelrequest.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
   public User toUser(UserRegisterRequest request){
        return User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();
    }

    public UserResponse toResponse(User userSaved){

        return new UserResponse(userSaved.getEmail(),
                userSaved.getFirstName(), userSaved.getLastName());
    }
}
