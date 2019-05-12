package com.nemk.educator.service;


import com.nemk.educator.api.viewmodel.UserViewModel;
import com.nemk.educator.model.User;
import com.nemk.educator.repository.UserRepository;
import com.nemk.educator.util.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements  UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public User save(User user) {
        String password = PasswordUtil.getPasswordHash(user.getPassword());
        user.setPassword(password);
        return userRepository.save(user);

    }
}
