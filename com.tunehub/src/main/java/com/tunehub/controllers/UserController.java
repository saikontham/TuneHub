package com.tunehub.controllers;

import com.tunehub.entities.Songs;
import com.tunehub.entities.Users;
import com.tunehub.services.SongService;
import com.tunehub.services.UserServiceImplementation;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserServiceImplementation userServiceImplementation;

    @Autowired
    private SongService songService;
    /***This method handles user registration.
     It checks if the provided email already exists using userServiceImplementation.emailExists.
     If the email does not exist (!emailExists), the user is added using userServiceImplementation.addUser.
     Print statements log messages indicating success or failure.
     Finally, it returns the view name "userlogin".**/

    @PostMapping("/register")
    public String addUser(@ModelAttribute Users users) {
        boolean status = userServiceImplementation.emailExists(users.getEmail());
        if (!status) {
            userServiceImplementation.addUser(users);
            System.out.println("ADDed");
        } else {
            System.out.println("Already exists");
        }

        return "userlogin";
    }

    /**
     * Request Mapping: This method is mapped to handle POST requests to "/validate" for validating user login credentials.
     * <p>
     * Parameters: It takes two parameters, email and password, from the request.
     * <p>
     * Login Validation: Calls userServiceImplementation.validateLogin to check if the provided email and password are valid.
     * <p>
     * Role Check: If the login is successful, it retrieves the user's role using userServiceImplementation.getRole.
     * <p>
     * @param session HttpSession to store user information.
     * Redirect: Redirects to either "adminhomepage" or "customerhomepage" based on the user's role. If login fails, it redirects to "userlogin".
     **/

    @PostMapping("/validate")
    public String validateLogin(@RequestParam String email, @RequestParam String password, HttpSession session, Model model) {
        if (userServiceImplementation.validateLogin(email, password) == true) {
            String role = userServiceImplementation.getRole(email);
            session.setAttribute("email",email);
            if (role.equals("admin")) {
                return "adminhomepage";
            } else {
                Users users=userServiceImplementation.getUser(email);
                boolean userStatus=users.isPremium();
                List<Songs> songsList= songService.viewallsongs();
                // Add the songs list to the model, making it accessible in the view

                model.addAttribute("songs",songsList);

                model.addAttribute("isPremium",userStatus);
                return "customerhomepage";
            }
        } else {
            return "userlogin";
        }
    }



    @GetMapping("/logout")
    public String logout(HttpSession session)
    {
        session.invalidate();
        return "userlogin";
    }

}
