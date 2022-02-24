package com.codingdojo.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.models.Language;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Long>{
	List<Language> findAll();
	
	@SuppressWarnings("unchecked")
	Language save( Language language );
	
	List<Language> findByid( int id );
	
	@Transactional
	void deleteByid( int id );
}
