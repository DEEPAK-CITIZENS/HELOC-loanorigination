package me.anichakra.poc.pilot.heloc.openbanking.web;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import me.anichakra.poc.pilot.heloc.openbanking.domain.BankAccount;
import me.anichakra.poc.pilot.heloc.openbanking.domain.IncomeData;
import me.anichakra.poc.pilot.heloc.openbanking.service.OpenBankingQueryService;

@RestController
public class OpenBankingQueryController {

	@Inject
	private OpenBankingQueryService openBankingQueryService;

	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/accounts")
	@ResponseBody
	public List<BankAccount> getAccounts() {
		return openBankingQueryService.getAccounts();
	}

	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/income/{id}")
	@ResponseBody
	public IncomeData getIncomeData(@PathVariable("id") Long id) {
		return openBankingQueryService.getIncomeData(id).orElse(null);
	}

	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/transactions/{accountId}")
	@ResponseBody
	public List<BankAccount> getTransactions(@PathVariable("accountId") String accountId) {
		return openBankingQueryService.getTransactions(accountId);
	}
}
