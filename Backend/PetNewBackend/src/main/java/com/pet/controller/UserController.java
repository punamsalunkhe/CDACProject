package com.pet.controller;


import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pet.entities.Shelter;
import com.pet.entities.User;
import com.pet.service.IShelterService;
import com.pet.service.IUserService;

import jakarta.servlet.http.HttpSession;
@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class UserController {

	@Autowired
	private IUserService userService;
	
	@Autowired
	private IShelterService shelterService;
	
    @GetMapping("/login")
    public String login() {
        return "login"; // Return the login page
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String email, @RequestParam String password, HttpSession session) {
        User user = userService.authenticateUser(email, password);
        if (user != null) {
            session.setAttribute("user_id", user.getId());
            session.setAttribute("role", user.getRole().toString());
            // Return user's role as part of the response
            return ResponseEntity.ok(Collections.singletonMap("role", user.getRole().toString()));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup"; // Return the signup page
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signup(
        @RequestParam String email,
        @RequestParam String password,
        @RequestParam String role,
        @RequestParam(required = false) String address,
        @RequestParam(required = false) String contact) {

        try {
            User user = userService.registerUser(email, password, role);
            
            if ("ROLE_SHELTER".equals(role)) {
                Shelter shelter = new Shelter();
                shelter.setAddress(address);
                shelter.setContact(contact);
                shelter.setUser(user);
                shelterService.saveShelter(shelter);
            }

            return ResponseEntity.ok("User registered successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Registration failed: " + e.getMessage());
        }
    }



    @GetMapping("/logout")
    public ResponseEntity<String> logout(HttpSession session) {
        session.invalidate();
        return ResponseEntity.ok("Logged out successfully");
    }

}
