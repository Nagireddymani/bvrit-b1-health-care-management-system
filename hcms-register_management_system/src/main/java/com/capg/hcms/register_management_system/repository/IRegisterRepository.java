package com.capg.hcms.register_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.hcms.register_management_system.model.User;

public interface IRegisterRepository extends JpaRepository<User, String> {

}
