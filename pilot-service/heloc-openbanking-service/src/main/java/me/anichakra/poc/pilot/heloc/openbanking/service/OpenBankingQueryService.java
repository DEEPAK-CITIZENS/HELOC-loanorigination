package me.anichakra.poc.pilot.heloc.openbanking.service;

import java.util.List;
import java.util.Optional;

import me.anichakra.poc.pilot.heloc.openbanking.domain.BankAccount;
import me.anichakra.poc.pilot.heloc.openbanking.domain.IncomeData;

public interface OpenBankingQueryService {

	List<BankAccount> getAccounts();

	Optional<IncomeData> getIncomeData(Long id);

	List<BankAccount> getTransactions(String accountId);
}
