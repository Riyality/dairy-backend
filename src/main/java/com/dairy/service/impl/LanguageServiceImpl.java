package com.dairy.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dairy.entity.DefaultLanguage;
import com.dairy.repository.FeedcompanyRepository;
import com.dairy.repository.LanguageRepository;
import com.dairy.service.LanguageService;

@Service
public class LanguageServiceImpl implements LanguageService {

	@Autowired
	private LanguageRepository languageRepository;

	@Override
	public Optional<DefaultLanguage> getdefaultLanguage() {
		Optional<DefaultLanguage> lang = languageRepository.findById(1);
		return lang;
	}

	
	
	@Override
	public boolean changeDefaultLanguage(String lang) {
		int result = languageRepository.updateLanguageById(1, lang);
		if (result == 1) {
			return true;
		}
		return false;
	}

}
