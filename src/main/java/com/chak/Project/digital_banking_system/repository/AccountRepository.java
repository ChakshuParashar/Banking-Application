package com.chak.Project.digital_banking_system.repository;

import com.chak.Project.digital_banking_system.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {
}
