package com.example.springboottesting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboottesting.model.Phone;
import com.example.springboottesting.service.PhoneService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/")
public class PhoneController {
	
	@Autowired
	private PhoneService phoneService;
	
	@PostMapping("phone")
	public ResponseEntity<Phone> createPhone(@RequestBody Phone phone) {
		return new ResponseEntity<Phone>(phoneService.savePhone(phone), HttpStatus.CREATED);
	}
	
	@GetMapping("phone/{id}")
	public ResponseEntity<Phone> phoneDetail(@PathVariable Long id) {
		return new ResponseEntity<Phone>(phoneService.getPhoneById(id), HttpStatus.OK);
	}
	
	@GetMapping("phone")
	public ResponseEntity<List<Phone>> phones() {
		return new ResponseEntity<List<Phone>>(phoneService.getAllPhone(), HttpStatus.OK);
	}
	
	@PutMapping("phone/{id}")
	public ResponseEntity<Phone> updatePhone(@PathVariable Long id,@RequestBody Phone phone) {
		return new ResponseEntity<Phone>(phoneService.savePhone(phone), HttpStatus.CREATED);
	}
	
	@DeleteMapping("phone/{id}")
	public ResponseEntity<String> deletePhone(@PathVariable Long id) {
		phoneService.deletePhoneById(id);
		return new ResponseEntity<String>("Deleted", HttpStatus.OK);
	}

}
