package com.nmsmoviebookingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nmsmoviebookingsystem.model.UserData;

public interface UserDataRepository extends JpaRepository<UserData,Integer>{
	
	 UserData findByUser_Id(long id);

}
