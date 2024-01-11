package com.example.springboottesting.repository;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.springboottesting.model.Phone;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class PhoneRepositoryTest {
	
	@Autowired
	private PhoneRepository phoneRepository;
	
	@Test
	public void phoneRepository_SaveAll_ReturnSavedPhone() {
		
		// Arrange
		Phone phone = Phone.builder().name("Realme").cost(500).build();
		
		// Act
		Phone savedPhone = phoneRepository.save(phone);
		
		// Assert
		Assertions.assertThat(savedPhone).isNotNull();
		Assertions.assertThat(savedPhone.getId()).isGreaterThan(0);
	}

	@Test
	public void phoneRepository_GetAll_ReturnMoreThenOnePhone() {
		
		// Arrange
		Phone phone = Phone.builder().name("Realme").cost(500).build();
		Phone phone1 = Phone.builder().name("Apple").cost(1500).build();
		
		phoneRepository.save(phone);
		phoneRepository.save(phone1);
		
		// Act
		List<Phone> phoneList = phoneRepository.findAll();
		
		// Assert
		Assertions.assertThat(phoneList).isNotNull();
		Assertions.assertThat(phoneList.size()).isEqualTo(2);
	}
	
	@Test
	public void phoneRepository_FindById_ReturnPhone() {
		
		// Arrange
		Phone phone = Phone.builder().name("Realme").cost(500).build();
		
		phoneRepository.save(phone);
		
		// Act
		Phone phoneList =  phoneRepository.findById(phone.getId()).get();
		
		// Assert
		Assertions.assertThat(phoneList).isNotNull();		
	}
	
	@Test
	public void phoneRepository_FindByName_ReturnPhone() {
		
		// Arrange
		Phone phone = Phone.builder().name("Realme").cost(500).build();
		
		phoneRepository.save(phone);
		
		// Act
		Phone phoneList =  phoneRepository.findByName(phone.getName()).get();
		
		// Assert
		Assertions.assertThat(phoneList).isNotNull();
	}
	
	@Test
	public void phoneRepository_UpdatePhone_ReturnPhoneNotNull() {
		
		// Arrange
		Phone phone = Phone.builder().name("Realme").cost(500).build();
		
		phoneRepository.save(phone);
		
		Phone phonesave = phoneRepository.findById(phone.getId()).get();
		phonesave.setName("Redme");
		phonesave.setCost(600);
		
		// Act
		Phone updatePhone =  phoneRepository.save(phonesave);
		
		// Assert
		Assertions.assertThat(updatePhone).isNotNull();
		Assertions.assertThat(updatePhone.getName()).isNotNull();
		Assertions.assertThat(updatePhone.getCost()).isNotNull();		
	}
	
	@Test
	public void phoneRepository_PhoneDelete_ReturnPhoneIsEmpty() {
		
		// Arrange
		Phone phone = Phone.builder().name("Realme").cost(500).build();
		
		phoneRepository.save(phone);
		
		// Act
		phoneRepository.deleteById(phone.getId());
		Optional<Phone> phoneReturn = phoneRepository.findById(phone.getId());
		
		// Assert
		Assertions.assertThat(phoneReturn).isEmpty();
	}
	
}
