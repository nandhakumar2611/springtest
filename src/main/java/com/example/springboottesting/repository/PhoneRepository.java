package com.example.springboottesting.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboottesting.model.Phone;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long> {

	Optional<Phone> findByName(String name);
}
