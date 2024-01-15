package com.tunehub.services;

import com.tunehub.entities.Users;
import com.tunehub.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements UserService{

    @Autowired
    private UserRepository userRepository;

    /**
     * Adds a new user to the database.
     *
     * @param users The user object to be saved.
     */
    public void addUser(Users users) {
        userRepository.save(users);
    }

    /**
     * Checks if an email already exists in the user repository.
     *
     * @param email The email to check for existence.
     * @return {@code true} if the email exists, {@code false} otherwise.
     */
    @Override
    public boolean emailExists(String email) {
        if(userRepository.findByEmail(email)==null)
        {
            return false;
        }
        else {
            return true;
        }
    }

    /**
     * Validates login credentials.
     *
     * @param email    User's email
     * @param password User's entered password
     * @return True if login is valid, false otherwise
     */

    @Override
    public boolean validateLogin(String email, String password) {
        Users users=userRepository.findByEmail(email);
        String dbpassword=users.getPassword();
        if(password.equals(dbpassword))
        {
            return true;
        }
      return false;
    }

    /**
     * Gets the role of a user based on their email.
     *
     * @param email The email of the user.
     * @return The role of the user, or null if the user is not found.
     */

    @Override
    public String getRole(String email) {
        Users users=userRepository.findByEmail(email);
        String role=users.getRole();
        return role;
    }

    @Override
    public Users getEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void updateUser(Users users) {
        userRepository.save(users);
    }

    @Override
    public Users getUser(String mail) {
        return userRepository.findByEmail(mail);
    }

}
