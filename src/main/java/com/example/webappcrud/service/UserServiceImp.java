package com.example.webappcrud.service;

import com.example.webappcrud.repositories.RoleRepository;
import com.example.webappcrud.repositories.UserRepository;
import com.example.webappcrud.models.Role;
import com.example.webappcrud.models.User;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    final PasswordEncoder passwordEncoder;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(int id) {
        User user = null;
        Optional<User> showUser = userRepository.findById(id);

        if (showUser.isPresent()) {
            user = showUser.get();
        }
        return user;
    }

    @Override
    public User getUserByLogin(String login) {
        User user = null;
        Optional<User> showUser = Optional.ofNullable(userRepository.findUserByLogin(login));

        if (showUser.isPresent()) {
            user = showUser.get();
        }
        return user;
    }

    @Override
    public Role getRoleByName(String roleName) {
        return roleRepository.findByRole(roleName);
    }

    @Override
    public void createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public void updateUser(User user) {
        if (!user.getPassword().equals(getUserById(user.getId()).getPassword())) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        userRepository.save(user);
    }

    @Override
    public void deleteUserById(int id) {
        userRepository.deleteById(id);
    }
}