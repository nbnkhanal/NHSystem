package com.nabinsoft.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nabinsoft.entity.User;

public interface UserRepository extends JpaRepository<User,String>{

}
