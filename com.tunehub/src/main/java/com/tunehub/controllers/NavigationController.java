package com.tunehub.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavigationController {

    /**
     * Returns the view name "userlogin" when the "/userlogin" endpoint is accessed via a GET request.
     *
     * @return The view name "userlogin".
     */

    @GetMapping("/userlogin")
    public String login()
    {
        return "userlogin";
    }


    /**
     * Handles GET requests for "/userregistration".
     * Returns the view name "userregistration".
     */
    @GetMapping("/userregisteration")
    public String registration()
    {
        return "userregisteration";
    }
    // Returns the view named "newsong" when accessed via a GET request
    @GetMapping("/newsong")
    public String newsong()
    {
        return "newsong";
    }

}
