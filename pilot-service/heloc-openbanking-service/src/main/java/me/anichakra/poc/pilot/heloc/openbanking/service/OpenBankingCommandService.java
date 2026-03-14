package me.anichakra.poc.pilot.heloc.openbanking.service;

import me.anichakra.poc.pilot.heloc.openbanking.domain.BankAccount;
import me.anichakra.poc.pilot.heloc.openbanking.domain.IncomeData;

public interface OpenBankingCommandService {

	BankAccount linkAccount(BankAccount account);

	IncomeData verifyIncome(Long accountId);
}
