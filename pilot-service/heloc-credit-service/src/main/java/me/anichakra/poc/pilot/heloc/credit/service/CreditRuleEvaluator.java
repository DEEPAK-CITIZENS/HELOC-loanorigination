package me.anichakra.poc.pilot.heloc.credit.service;

import me.anichakra.poc.pilot.heloc.credit.domain.CreditDecision;
import me.anichakra.poc.pilot.heloc.credit.domain.CreditReport;
import org.springframework.stereotype.Component;

/**
 * Java-based credit rule evaluator replacing Drools/KIE rules engine.
 * Implements the same logic as heloc-credit-rules.drl:
 *   score >= 680 → APPROVED
 *   620 <= score < 680 → CONDITIONAL
 *   score < 620 → DECLINED
 */
@Component
public class CreditRuleEvaluator {

	public void evaluate(CreditReport report, CreditDecision decision) {
		int creditScore = report.getCreditScore();

		if (creditScore >= 680) {
			decision.setDecision("APPROVED");
			decision.setConditions("Standard approval");
		} else if (creditScore >= 620) {
			decision.setDecision("CONDITIONAL");
			decision.setConditions("Additional documentation required");
		} else {
			decision.setDecision("DECLINED");
			decision.setConditions("Credit score below minimum threshold");
		}
	}
}
