package com.school.schoolrepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.schoolentity.SchoolEntity;

public interface SchoolRepository extends JpaRepository<SchoolEntity, Integer>{

}
