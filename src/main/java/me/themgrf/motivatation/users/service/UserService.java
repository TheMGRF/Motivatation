package me.themgrf.motivatation.users.service;

import me.themgrf.motivatation.entities.User;

public interface UserService {

    void save(User user);

    User findByUsername(String username);

    User findByEmail(String email);

}
