package io.sercurity.securityStudy.repository;

import io.sercurity.securityStudy.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Account, Long> {

    Account findByUsername(String username);
}
