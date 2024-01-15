package com.tunehub.services;

import com.tunehub.entities.Songs;
import com.tunehub.entities.Users;


public interface UserService {
    public void addUser(Users users);

   public boolean emailExists(String email);

    public boolean validateLogin(String email, String password);

    public String getRole(String email);

    public Users getEmail(String email);
    public void updateUser(Users users);

    public Users getUser(String mail);
}

