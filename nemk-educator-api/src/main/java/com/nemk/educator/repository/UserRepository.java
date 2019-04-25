package com.nemk.educator.repository;

import com.nemk.educator.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

//    Optional<User> findByUsernameOrEmail(String username, String email);

    Optional<User> findById(String id);
}
