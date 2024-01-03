package com.dairy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dairy.entity.FeedType;

@Repository
public interface FeedTypeRepository extends JpaRepository<FeedType, Long> {

}
