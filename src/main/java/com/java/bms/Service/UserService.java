package com.java.bms.Service;

import com.java.bms.Misc.PasswordUtil;
import com.java.bms.Model.User;
import com.java.bms.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordUtil passwordUtil;

    // Fetch user by username
    public User fetchByUserName(String userName) {
        return userRepository.fetchByUserName(userName);
    }

    // Create a new user with password encryption
    public User createNewUser(User user) {
        if (userRepository.fetchByUserName(user.getUserName()) == null) {
            String encryptedPassword = passwordUtil.encryptPassword(user.getPassword());
            user.setPassword(encryptedPassword);
            return userRepository.save(user);
        } else {
            throw new RuntimeException("User already exists");
        }
    }


    // Fetch all users
    public List<User> fetchAllUsers() {
        return userRepository.findAll();
    }

    // Fetch user by ID
    public Optional<User> fetchUserById(int id) {
        return userRepository.findById(id);
    }

    // Update user
    public User updateUser(User updatedUser) {
        User existingUser = userRepository.findById(updatedUser.getId())
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + updatedUser.getId()));

        existingUser.setUserName(updatedUser.getUserName());
        existingUser.setMobile(updatedUser.getMobile());
        existingUser.setEmailId(updatedUser.getEmailId());

        if (updatedUser.getPassword() != null && !updatedUser.getPassword().isEmpty()) {
            // Encrypt the new password
            existingUser.setPassword(passwordUtil.encryptPassword(updatedUser.getPassword()));
        }
        return userRepository.save(existingUser);
    }

    // Delete user
    public void deleteUserById(int id) {
        userRepository.deleteById(id);
    }

    public Page<User> fetchAllUsersPaginated(Pageable pageable) {
        return userRepository.findAll(pageable);
    }
}
