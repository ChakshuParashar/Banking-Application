package com.chak.Project.digital_banking_system.repository;

import com.chak.Project.digital_banking_system.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
