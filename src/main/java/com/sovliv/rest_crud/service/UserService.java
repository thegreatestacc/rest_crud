package com.sovliv.rest_crud.service;

import com.sovliv.rest_crud.exception.ResourceNotFoundException;
import com.sovliv.rest_crud.model.User;
import com.sovliv.rest_crud.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<Iterable<User>> getAllUsers() {
        logger.info("*** all users found ***");
        userRepository.findAll().forEach(role -> role.setRoles(null));
        Iterable<User> users = userRepository.findAll();
        return ResponseEntity.ok().body(users);
    }

    public ResponseEntity<User> getOneUser(Long id) throws ResourceNotFoundException {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("user not found for this id: " + id));
        logger.info("*** user found ***");
        return ResponseEntity.ok().body(user);
    }

    public ResponseEntity<User> create(User user) {
        logger.info("*** user created ***");
        userRepository.save(user);
        return ResponseEntity.ok().body(user);
    }

    public ResponseEntity<User> update(User user, Long id) {
        Optional<User> optional = userRepository.findById(id);
        if (optional.isEmpty()) {
            throw new RuntimeException("*** user not found ***");
        }
        user.setId(id);
        logger.info("*** user updated ***");
        User savedUser = userRepository.save(user);
        return ResponseEntity.ok().body(savedUser);
    }

    public ResponseEntity delete(Long id) {
        logger.info("*** user deleted ***");
        userRepository.deleteById(id);
        return ResponseEntity.ok().body("user with id: " + id + " deleted");
    }

    @Transactional
    public Iterable<User> saveAll(List<User> users) {
        logger.info("*** all users saved ***");
        return userRepository.saveAll(users);
    }
}
