package me.anichakra.poc.pilot.heloc.pricing.rule;

/**
 * Java-based implementation of the HELOC pricing rules.
 * Replaces OpenL Tablets XLS-based rules with equivalent logic.
 * 
 * Base Rate table (by credit score range and LTV):
 *   740+:  LTV<=0.6 -> 3.25, LTV<=0.8 -> 3.75, LTV<=1.0 -> 4.25
 *   680-739: LTV<=0.6 -> 4.50, LTV<=0.8 -> 5.00, LTV<=1.0 -> 5.75
 *   620-679: LTV<=0.6 -> 6.00, LTV<=0.8 -> 6.75, LTV<=1.0 -> 7.50
 *
 * Margin table (by state and property type):
 *   CA/SFR -> 0.50, CA/CONDO -> 0.75
 *   NY/SFR -> 0.50, NY/CONDO -> 0.75
 *   TX/SFR -> 0.25, TX/CONDO -> 0.50
 *   FL/SFR -> 0.50, FL/CONDO -> 0.75
 *
 * Promotional Rate table (by credit score range):
 *   740+ -> 1.99, 680-739 -> 2.99, 620-679 -> 3.99
 */
public class HelocPricingRuleImpl implements HelocPricingRuleTemplate {

	@Override
	public double getBaseRate(int creditScore, double ltv) {
		if (creditScore >= 740) {
			if (ltv <= 0.6) return 3.25;
			if (ltv <= 0.8) return 3.75;
			return 4.25;
		} else if (creditScore >= 680) {
			if (ltv <= 0.6) return 4.50;
			if (ltv <= 0.8) return 5.00;
			return 5.75;
		} else if (creditScore >= 620) {
			if (ltv <= 0.6) return 6.00;
			if (ltv <= 0.8) return 6.75;
			return 7.50;
		}
		return 9.99; // below minimum score
	}

	@Override
	public double getMargin(String state, String propertyType) {
		if (state == null || propertyType == null) return 0.50;
		String s = state.toUpperCase();
		String p = propertyType.toUpperCase();
		switch (s) {
			case "CA":
				return "SFR".equals(p) ? 0.50 : 0.75;
			case "NY":
				return "SFR".equals(p) ? 0.50 : 0.75;
			case "TX":
				return "SFR".equals(p) ? 0.25 : 0.50;
			case "FL":
				return "SFR".equals(p) ? 0.50 : 0.75;
			default:
				return 0.50;
		}
	}

	@Override
	public double getPromotionalRate(int creditScore) {
		if (creditScore >= 740) return 1.99;
		if (creditScore >= 680) return 2.99;
		if (creditScore >= 620) return 3.99;
		return 5.99; // below minimum score
	}
}
