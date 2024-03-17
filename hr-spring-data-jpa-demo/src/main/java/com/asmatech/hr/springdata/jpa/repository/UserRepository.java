package com.asmatech.hr.springdata.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asmatech.hr.springdata.jpa.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
