package com.nmsmoviebookingsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nmsmoviebookingsystem.model.FileDB;

@Repository
public interface FileDBRepository extends JpaRepository<FileDB, String> {
	
	FileDB findByNameIgnoreCase(String name);
	
	List<FileDB> findAll();
}