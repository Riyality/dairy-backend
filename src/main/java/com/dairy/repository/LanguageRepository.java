package com.dairy.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dairy.entity.DefaultLanguage;

@Repository
public interface LanguageRepository extends JpaRepository<DefaultLanguage, Integer> {

	@Modifying
	@Transactional
	@Query("UPDATE DefaultLanguage d SET d.language = :newLanguage WHERE d.id = :id")
	int updateLanguageById(@Param("id") Integer id, @Param("newLanguage") String newLanguage);
	//C
	
}
