package me.anichakra.poc.pilot.heloc.openbanking.service.impl;

import javax.inject.Inject;

import me.anichakra.poc.pilot.framework.annotation.CommandService;
import me.anichakra.poc.pilot.framework.annotation.Event;
import me.anichakra.poc.pilot.framework.annotation.EventObject;
import me.anichakra.poc.pilot.heloc.openbanking.domain.BankAccount;
import me.anichakra.poc.pilot.heloc.openbanking.domain.IncomeData;
import me.anichakra.poc.pilot.heloc.openbanking.repo.BankAccountRepository;
import me.anichakra.poc.pilot.heloc.openbanking.repo.IncomeDataRepository;
import me.anichakra.poc.pilot.heloc.openbanking.service.OpenBankingCommandService;

@CommandService
public class DefaultOpenBankingCommandService implements OpenBankingCommandService {

	@Inject
	private BankAccountRepository bankAccountRepository;

	@Inject
	private IncomeDataRepository incomeDataRepository;

	@Override
	@Event(name = "sourcing", object = EventObject.RESPONSE)
	public BankAccount linkAccount(BankAccount account) {
		return bankAccountRepository.saveAndFlush(account);
	}

	@Override
	@Event(name = "sourcing", object = EventObject.RESPONSE)
	public IncomeData verifyIncome(Long accountId) {
		IncomeData incomeData = new IncomeData();
		return incomeDataRepository.saveAndFlush(incomeData);
	}
}
