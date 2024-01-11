package com.example.springboottesting.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboottesting.model.Phone;
import com.example.springboottesting.repository.PhoneRepository;
import com.example.springboottesting.service.PhoneService;

@Service
public class PhoneServiceImpl implements PhoneService {

	@Autowired
	private PhoneRepository phoneRepository;

	@Override
	public Phone savePhone(Phone phone) {
		return phoneRepository.save(phone);
	}

	@Override
	public List<Phone> getAllPhone() {
		return phoneRepository.findAll();
	}

	@Override
	public Phone getPhoneById(Long id) {
		Phone phone = phoneRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Phone not found"));
		return phone;
	}

	@Override
	public Phone updatePhoneById(Phone updatePhone, Long id) {
		Phone phone = phoneRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Phone not found"));
		phone.setName(updatePhone.getName());
		phone.setCost(updatePhone.getCost());
		return phoneRepository.save(phone);
	}

	@Override
	public void deletePhoneById(Long id) {
		Phone phone = phoneRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Phone not found"));
		phoneRepository.delete(phone);
	}

}
