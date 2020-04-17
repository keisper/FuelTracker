package org.isj.fueltracker.restControllers;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/")
@CrossOrigin("*")
public class LoginRestController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String LoginPage(HttpServletRequest request, HttpServletResponse response){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth.isAuthenticated()){
            return "redirect:/index";
        }
        else{
            return "Vous avez entrer de mauvais paramètres";
        }
    }
}
