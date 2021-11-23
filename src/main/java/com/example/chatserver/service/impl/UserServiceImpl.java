package com.example.chatserver.service.impl;

import com.example.chatserver.Repositories.UserRepository;
import com.example.chatserver.models.User;
import com.example.chatserver.service.inter.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUser(Long id) {
        User saved = userRepository.findById(id).get();
        return saved;
    }

    @Override
    public User getUser(String email) {
        User saved = userRepository.findByEmail(email);
        return saved;
    }

    @Override
    public User addNewUser(User user) {

        User saved = this.getUser(user.getEmail());
        if (saved != null){
            return null;
        }
        saved = userRepository.save(user);
        return saved;
    }

    @Override
    public User validate(String email, String password) {
        User saved = this.getUser(email);
        if(saved!=null && saved.getPassword().equals(password)){
            return saved;
        }
        return null;
    }
}
