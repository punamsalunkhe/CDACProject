package com.app.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;


@Entity
@Table(name = "roles")

public class Role extends BaseEntity {
	@Enumerated(EnumType.STRING)
	@Column(unique = true)
	private RoleEnum roleName;
	
	// Getter for roleName
	public RoleEnum getRoleName() {
	    return roleName;
	}

	// Setter for roleName
	public void setRoleName(RoleEnum roleName) {
	    this.roleName = roleName;
	}
}