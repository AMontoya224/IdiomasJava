package com.codingdojo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.models.Language;
import com.codingdojo.repositories.LanguageRepository;

@Service
public class LanguageService {
	private final LanguageRepository languageRepository;
	
	public LanguageService( LanguageRepository languageRepository ) {
		this.languageRepository = languageRepository;
	}
	
	public List<Language> selectAllFromLanguages(){
		List<Language> languagesList = languageRepository.findAll();
		if ( languagesList.isEmpty() ) {
			Language languageVacio = new Language();
			languagesList.add(languageVacio);
		}
		return languagesList;
	}
	
	public Language insertIntoLanguages( Language language ) {
		return languageRepository.save(language);
	}
	
	public Language selectFromLanguagesWhereId( int id ){
		List<Language> languageList = languageRepository.findByid(id);
		if ( languageList.isEmpty() ) {
			Language languageVacio = new Language();
			return languageVacio;
		}
		return languageList.get(0);
	}
	
	public void updateLanguage( Language language ) {
		languageRepository.save(language);
	}
	
	public void deleteFromLanguage( int id ) {
		languageRepository.deleteByid( id );
	}
}
