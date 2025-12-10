package com.solardev.UserAPI.service;

import com.solardev.UserAPI.entity.User;
import com.solardev.UserAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    public User updateUser(User userToUpdate, Long id) {

        User user = userRepository.findById(id).orElseThrow();
        user.setName(userToUpdate.getName());
        user.setDob(userToUpdate.getDob());

        return userRepository.save(userToUpdate);
    }

    public void deleteUser(Long id) {
        if(userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
        }
    }


}
