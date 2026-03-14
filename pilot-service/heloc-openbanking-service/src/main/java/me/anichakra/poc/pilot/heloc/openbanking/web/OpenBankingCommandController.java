package me.anichakra.poc.pilot.heloc.openbanking.web;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import me.anichakra.poc.pilot.heloc.openbanking.domain.BankAccount;
import me.anichakra.poc.pilot.heloc.openbanking.domain.IncomeData;
import me.anichakra.poc.pilot.heloc.openbanking.service.OpenBankingCommandService;

@RestController
public class OpenBankingCommandController {

	@Inject
	private OpenBankingCommandService openBankingCommandService;

	@PostMapping("/account/link")
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public BankAccount linkAccount(@RequestBody BankAccount account) {
		return openBankingCommandService.linkAccount(account);
	}

	@PostMapping("/income/verify/{accountId}")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public IncomeData verifyIncome(@PathVariable("accountId") Long accountId) {
		return openBankingCommandService.verifyIncome(accountId);
	}
}
