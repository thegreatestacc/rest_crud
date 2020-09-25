package com.sovliv.rest_crud.service;

import com.sovliv.rest_crud.model.User;
import com.sovliv.rest_crud.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    public Iterable<User> getAllUsers() {
        logger.info("*** all users found ***");
        return userRepository.findAll();
    }

    public User getOneUser(Long id) {
        Optional<User> optional = userRepository.findById(id);
        if (optional.isEmpty()) {
            throw new RuntimeException("user not found");
        }
        logger.info("*** user received ***");
        return optional.get();
    }

    public User create(User user) {
        logger.info("*** user created ***");
        return userRepository.save(user);
    }

    public User update(User user, Long id) {
        Optional<User> optional = userRepository.findById(id);
        if (optional.isEmpty()) {
            throw new RuntimeException("*** user not found ***");
        }
        user.setId(id);
        logger.info("*** user updated ***");
        return userRepository.save(user);
    }

    public void delete(Long id) {
        logger.info("*** user deleted ***");
        userRepository.deleteById(id);
    }

    @Transactional
    public Iterable<User> saveAll(List<User> users) {
        logger.info("*** all users saved ***");
        return userRepository.saveAll(users);
    }
}
