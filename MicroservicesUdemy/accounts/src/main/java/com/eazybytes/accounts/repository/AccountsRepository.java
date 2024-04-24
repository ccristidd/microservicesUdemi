package com.eazybytes.accounts.repository;


import com.eazybytes.accounts.model.Accounts;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface AccountsRepository extends CrudRepository<Accounts, Long> {

    Optional<Accounts> findByCustomerId(Integer customerId);

    @Transactional
    @Modifying
    void deleteByCustomerId(Integer customerId);
}
