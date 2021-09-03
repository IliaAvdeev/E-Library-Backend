package com.bookwarm.library.services;

import com.bookwarm.library.persistence.model.User;
import com.bookwarm.library.persistence.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    public User findByEmail(String email, String password) {
        User user = userRepository.findByEmail(email);
        if ((user != null) && (user.getPassword().equals(password))) {
            return userRepository.findByEmail(email);
        } return null;
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User findOne(long id) {
        return userRepository.findById(id)
                .orElse(null);
    }

    public User create(User user) {
        return userRepository.save(user);
    }

    public void delete(long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        }
    }

    public User update(User user, long id) {
        if ((user.getId() == id) && (userRepository.existsById(id))) {
            return userRepository.save(user);
        } return null;
    }
}
