package me.anichakra.poc.pilot.heloc.pricing.rule;

import java.util.Map;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import me.anichakra.poc.pilot.framework.rule.api.RuleService;

/**
 * Provides a Java-based pricing rule implementation as a fallback
 * when the OpenL Tablets engine fails to initialize.
 */
@Configuration
public class PricingRuleConfiguration {

	@Bean
	@Primary
	public HelocPricingRuleTemplate helocPricingRuleTemplate() {
		return new HelocPricingRuleImpl();
	}

	@Bean
	@Primary
	public RuleService<HelocPricingRuleTemplate> pricingRuleService() {
		HelocPricingRuleTemplate template = new HelocPricingRuleImpl();
		return new RuleService<HelocPricingRuleTemplate>() {
			@Override
			public HelocPricingRuleTemplate getRuleTemplate() {
				return template;
			}

			@Override
			public HelocPricingRuleTemplate getRuleTemplate(String contextName) {
				return template;
			}

			@Override
			public HelocPricingRuleTemplate getRuleTemplate(String contextName, Map<String, Object> params) {
				return template;
			}
		};
	}
}
