package com.noobs.postgetdelrequest.repository;

import com.noobs.postgetdelrequest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
