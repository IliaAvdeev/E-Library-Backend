package com.bookwarm.library.services;

import com.bookwarm.library.exceptions.UserAlreadyExistsException;
import com.bookwarm.library.persistence.model.User;
import com.bookwarm.library.persistence.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public boolean ifEmailExists(String email) {
        return findByEmail(email) != null;
    }

    public boolean ifUsernameExists(String username) {
        return findByUsername(username) != null;
    }

    public User create(User user) throws UserAlreadyExistsException {
        if (ifEmailExists(user.getEmail())) {
            throw new UserAlreadyExistsException("Пользователь с таким e-mail уже существует.");
        }
        if (ifUsernameExists(user.getUsername())) {
            throw new UserAlreadyExistsException("Пользователь с таким именем уже существует.");
        }
        user.setPassword(encodePassword(user.getPassword()));
        return userRepository.save(user);
    }

    private String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }

    public boolean verifyPassword(User user, String password) {
        return passwordEncoder.matches(password, user.getPassword());
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return findByUsername(s);
    }
}
