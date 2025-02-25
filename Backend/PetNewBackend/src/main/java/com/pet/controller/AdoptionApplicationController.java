package com.pet.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pet.dto.ApplicationRequest;
import com.pet.entities.AdoptionApplication;
import com.pet.entities.AdoptionApplicationDetails;
import com.pet.entities.Pet;
import com.pet.entities.User;
import com.pet.enums.ApplicationStatus;
import com.pet.enums.HavePet;
import com.pet.service.IAdoptionApplicationDetailsService;
import com.pet.service.IAdoptionApplicationService;

@RestController
@RequestMapping("/adoption-application")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class AdoptionApplicationController {

	@Autowired
    private IAdoptionApplicationService adoptionApplicationService;

    @Autowired
    private IAdoptionApplicationDetailsService adoptionApplicationDetailsService;
	
    @PostMapping
    public ResponseEntity<String> submitApplication(@RequestBody ApplicationRequest request) {
        try {
            // Create and save the adoption application
            AdoptionApplication application = new AdoptionApplication();
            application.setPet(new Pet(request.getPetId()));
            application.setUser(new User(request.getUserId()));
            application.setApplicationStatus(ApplicationStatus.PENDING);
            application.setSubmissionDate(LocalDate.parse(request.getSubmissionDate()));

            AdoptionApplication savedApplication = adoptionApplicationService.saveAdoptionApplication(application);

            // Create and save the adoption application details
            AdoptionApplicationDetails details = new AdoptionApplicationDetails();
            details.setApplicationId(savedApplication);
            details.setName(request.getDetails().getName());
            details.setAddress(request.getDetails().getAddress());
            details.setAge(request.getDetails().getAge());
            details.setEmail(request.getDetails().getEmail());
            details.setOccupation(request.getDetails().getOccupation());
            details.setHavePets(HavePet.valueOf(request.getDetails().getHavePet()));
            details.setPetName(request.getDetails().getPetName());
            details.setPetAge(request.getDetails().getPetAge());
            details.setPetSpecies(request.getDetails().getPetSpecies());
            details.setPetDescription(request.getDetails().getPetDescription());

            adoptionApplicationDetailsService.saveAdoptionApplicationDetails(details);

            return new ResponseEntity<>("Application submitted successfully!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to submit application", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
