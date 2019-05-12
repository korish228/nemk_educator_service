package com.nemk.educator.repository;

import com.nemk.educator.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, String>{

    User findByEmailOrUsernameIgnoreCase(String email,String username );

    User findByEmail(String email);

//    User findByUsername(String username);
}
