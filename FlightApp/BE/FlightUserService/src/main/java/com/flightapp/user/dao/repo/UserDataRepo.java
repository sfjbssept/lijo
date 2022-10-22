package com.flightapp.user.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightapp.user.dao.entity.UserData;

public interface UserDataRepo extends JpaRepository<UserData, Integer> {

}
