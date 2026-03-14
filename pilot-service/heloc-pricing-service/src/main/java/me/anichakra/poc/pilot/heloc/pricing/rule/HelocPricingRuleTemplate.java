package me.anichakra.poc.pilot.heloc.pricing.rule;

public interface HelocPricingRuleTemplate {

	double getBaseRate(int creditScore, double ltv);

	double getMargin(String state, String propertyType);

	double getPromotionalRate(int creditScore);
}
