package com.example.springboottesting.service;

import java.util.List;

import com.example.springboottesting.model.Phone;

public interface PhoneService {

	Phone savePhone(Phone phone);

	List<Phone> getAllPhone();

	Phone getPhoneById(Long id);

	Phone updatePhoneById(Phone phone, Long id);

	void deletePhoneById(Long id);

}
