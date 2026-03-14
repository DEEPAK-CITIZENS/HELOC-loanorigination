package me.anichakra.poc.pilot.heloc.openbanking.service.impl;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import me.anichakra.poc.pilot.framework.annotation.Event;
import me.anichakra.poc.pilot.framework.annotation.QueryService;
import me.anichakra.poc.pilot.heloc.openbanking.domain.BankAccount;
import me.anichakra.poc.pilot.heloc.openbanking.domain.IncomeData;
import me.anichakra.poc.pilot.heloc.openbanking.repo.BankAccountRepository;
import me.anichakra.poc.pilot.heloc.openbanking.repo.IncomeDataRepository;
import me.anichakra.poc.pilot.heloc.openbanking.service.OpenBankingQueryService;

@QueryService
public class DefaultOpenBankingQueryService implements OpenBankingQueryService {

	@Inject
	private BankAccountRepository bankAccountRepository;

	@Inject
	private IncomeDataRepository incomeDataRepository;

	@Override
	@Event(name = "tracing")
	public List<BankAccount> getAccounts() {
		return bankAccountRepository.findAll();
	}

	@Override
	@Event(name = "tracing")
	public Optional<IncomeData> getIncomeData(Long id) {
		return incomeDataRepository.findById(id);
	}

	@Override
	@Event(name = "tracing")
	public List<BankAccount> getTransactions(String accountId) {
		return bankAccountRepository.findByAccountId(accountId);
	}
}
