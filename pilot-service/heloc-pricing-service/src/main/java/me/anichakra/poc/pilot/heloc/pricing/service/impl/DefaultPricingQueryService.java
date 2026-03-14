package me.anichakra.poc.pilot.heloc.pricing.service.impl;

import javax.inject.Inject;

import me.anichakra.poc.pilot.framework.annotation.Event;
import me.anichakra.poc.pilot.framework.annotation.EventObject;
import me.anichakra.poc.pilot.framework.annotation.QueryService;
import me.anichakra.poc.pilot.framework.rule.api.RuleService;
import me.anichakra.poc.pilot.heloc.pricing.domain.PricingRequest;
import me.anichakra.poc.pilot.heloc.pricing.domain.PricingResult;
import me.anichakra.poc.pilot.heloc.pricing.rule.HelocPricingRuleTemplate;
import me.anichakra.poc.pilot.heloc.pricing.service.PricingQueryService;

@QueryService
public class DefaultPricingQueryService implements PricingQueryService {

	@Inject
	private RuleService<HelocPricingRuleTemplate> ruleService;

	private HelocPricingRuleTemplate getRuleTemplate() {
		return ruleService.getRuleTemplate(null, null);
	}

	@Override
	@Event(name = {"sourcing", "tracing"}, object = EventObject.RESPONSE)
	public PricingResult calculatePricing(PricingRequest request) {
		HelocPricingRuleTemplate template = getRuleTemplate();
		PricingResult result = new PricingResult();

		double baseRate = template.getBaseRate(request.getCreditScore(), request.getLtv());
		double margin = template.getMargin(request.getState(), request.getPropertyType());
		double promotionalRate = template.getPromotionalRate(request.getCreditScore());

		result.setBaseRate(baseRate);
		result.setMargin(margin);
		result.setApr(baseRate + margin);
		result.setPromotionalRate(promotionalRate);

		return result;
	}

	@Override
	@Event(name = "tracing", object = EventObject.RESPONSE)
	public double getRate(int creditScore, double ltv) {
		HelocPricingRuleTemplate template = getRuleTemplate();
		return template.getBaseRate(creditScore, ltv);
	}
}
