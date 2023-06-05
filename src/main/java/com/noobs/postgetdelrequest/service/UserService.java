package com.noobs.postgetdelrequest.service;

import com.noobs.postgetdelrequest.dto.UserRegisterRequest;
import com.noobs.postgetdelrequest.dto.UserResponse;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    UserResponse saveUser(UserRegisterRequest request);

     UserResponse getUser(Long id);
//new line
      void deletedUser(Long id);
}
