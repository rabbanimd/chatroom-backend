package com.example.chatserver.service.inter;

import com.example.chatserver.models.User;

public interface UserService {
    public User getUser(Long id);
    public User getUser(String email);
    public User addNewUser(User user);
    public User validate(String email, String password);
}
