package me.anichakra.poc.pilot.heloc.pricing.service;

import me.anichakra.poc.pilot.heloc.pricing.domain.PricingRequest;
import me.anichakra.poc.pilot.heloc.pricing.domain.PricingResult;

public interface PricingQueryService {

	PricingResult calculatePricing(PricingRequest request);

	double getRate(int creditScore, double ltv);
}
