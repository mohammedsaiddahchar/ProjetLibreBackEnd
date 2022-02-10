package net.atos.service;

import net.atos.exception.UserNotFoundException;
import net.atos.model.User;
import net.atos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepo;

    public User addUser(User user) {
        return userRepo.save(user);
    }

    public User updateUser(User user) {
        return userRepo.save(user);
    }

    public User findUserById(Long id) {
        return userRepo.findUserById(id).orElseThrow(() -> new UserNotFoundException("User by id : " + id + " was not found."));
    }

    public List<User> findAllUsers() {
        return userRepo.findAll();
    }

    public void deleteById(Long id) {
        userRepo.deleteUserById(id);
    }


}
