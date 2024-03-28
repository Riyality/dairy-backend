package com.dairy.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dairy.constants.MessageConstants;
import com.dairy.entity.DefaultLanguage;
import com.dairy.service.LanguageService;

@RestController
@RequestMapping("/language")
public class LanguageController {

	@Autowired
	private LanguageService languageService;

	@GetMapping
	Optional<DefaultLanguage> getDefaullLanguage() {
		Optional<DefaultLanguage> Lang = languageService.getdefaultLanguage();
		return Lang;
	}

	@PutMapping("/{lang}")
	public ResponseEntity<String> changeDefaultLanguage(@PathVariable String lang) {

		boolean langChanged = languageService.changeDefaultLanguage(lang);
		if (langChanged) {
			return ResponseEntity.status(HttpStatus.CREATED).body("Language Changed Successfully");
		}
		return ResponseEntity.status(HttpStatus.CREATED).body("Failed To Change The Language");	
		}

}
