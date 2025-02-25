package com.pet.entities;

import java.time.LocalDate;


import com.pet.enums.ApplicationStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Table(name="adoptionApplications")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AdoptionApplication {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="application_id")
	private int applicationId;
	
	@Column(name="submission_date")
	private LocalDate submissionDate;
	
	@Column(length = 10)
	@Enumerated(EnumType.STRING)
	private ApplicationStatus applicationStatus;
	
	//adoption_application-->payment(@oneToOne)
	//adoption_application-->user(@ManyToOne)
	//adoption_application-->pet(@ManyToOne)
	//adoption_application-->appointment(@oneToOne)
	//adoption_application-->shelter(@ManyToOne)
	//adoption_application-->adoptionApplicationDetails(@OnetoOne)
	
	@OneToOne(mappedBy = "adoptionApplication")
	private Payment payment;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "pet_id")
	private Pet pet;
	
	@OneToOne
	@JoinColumn(name = "appointment_id")
	private Appointment appointment;
	
	@ManyToOne
	@JoinColumn(name = "shelter_id")
	private Shelter shelter;
	
	@OneToOne(mappedBy = "applicationId")
	private AdoptionApplicationDetails appDetails;
}
