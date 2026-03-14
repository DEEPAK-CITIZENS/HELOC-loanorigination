package me.anichakra.poc.pilot.heloc.openbanking.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.anichakra.poc.pilot.heloc.openbanking.domain.BankAccount;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {

	List<BankAccount> findByAccountId(String accountId);
}
