package com.university.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.university.entity.University;

@Repository
public interface UniversityRepository extends JpaRepository<University, Integer> {

	public List<University> findByDept(String dept);
}
