package com.pet.entities;

import java.time.LocalDateTime;



import org.hibernate.annotations.CreationTimestamp;

import com.pet.enums.PaymentStatus;

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
@Table(name="payments")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Payment {	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="payment_id")
	private int paymentId;
	
	@Column(length=20)
	private double amount;
	
	@CreationTimestamp 
	@Column(name="timestamp")
	private LocalDateTime timestamp;
	
	@Column(length = 10)
	@Enumerated(EnumType.STRING)
	private PaymentStatus pay_status;
	
	//payment-->shelter(@ManytoOne)
	//payment-->user(@ManytoOne)
	//payment-->adoption_application(@oneToOne)
	
	@ManyToOne
	@JoinColumn(name = "shelter_id")
	private Shelter shelter;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@OneToOne
	@JoinColumn(name = "application_id")
	private AdoptionApplication adoptionApplication;

}
