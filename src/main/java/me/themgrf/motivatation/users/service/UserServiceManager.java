package me.themgrf.motivatation.users.service;

import me.themgrf.motivatation.Motivatation;
import me.themgrf.motivatation.entities.User;
import me.themgrf.motivatation.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceManager implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(User user) {
        PasswordEncoder passwordEncoder = Motivatation.getInstance().passwordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setConfirmedPassword(passwordEncoder.encode(user.getConfirmedPassword()));
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
