package com.pet.entities;

import java.time.LocalDate;
import java.util.List;



import com.pet.enums.RoleEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="users")
@Getter
@Setter
public class User extends BaseEntity{
			
	@Column(length = 35, unique = true)
	private String email;
	
	/* @DateTimeFormat(pattern = "yyyy-MM-dd") */
	@Column(name="reg_date")
	private LocalDate registrationDate;
	
	private String password;
	
	private String profilePicPath;
	
	@Column(name = "role")
    @Enumerated(EnumType.STRING)
	private RoleEnum role;
	
	public User() {
		super();
	}
	
//	@ElementCollection(targetClass = RoleEnum.class, fetch = FetchType.EAGER)
//    @Enumerated(EnumType.STRING)
//    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
//    @Column(name = "role_name")
//    private Set<RoleEnum> userRoles;
	
	
	//user-->payment(@OneToMany)
	//user-->shelter(@OneToOne)
	//user-->adoption_application(@oneTomany)
	//user-->appointment(@OnetoMany)

	@OneToMany(mappedBy = "user")
	private List<Payment> payments;
	
	@OneToMany(mappedBy = "user")
	private List<AdoptionApplication> adoptionApplications;
	
	@OneToMany(mappedBy = "user")
	private List<Appointment> appointments;

	@OneToOne(mappedBy = "user")
	private Shelter shelter;
	
	
	public User(int userId) {
		
	}
}
