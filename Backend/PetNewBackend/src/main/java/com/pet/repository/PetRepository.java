package com.pet.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pet.entities.Pet;
import com.pet.enums.PetCategory;

public interface PetRepository extends JpaRepository<Pet, Integer>{

	@Query("SELECT p FROM Pet p WHERE p.shelter.id = :shelterId")
    List<Pet> findPetsByShelterId(@Param("shelterId") Integer shelterId);
	
	List<Pet> findByCategory(PetCategory category);

	@Query("SELECT p FROM Pet p WHERE p.pet_id = :petId")
    Pet getById(@Param("petId") Integer petId);
	
}
