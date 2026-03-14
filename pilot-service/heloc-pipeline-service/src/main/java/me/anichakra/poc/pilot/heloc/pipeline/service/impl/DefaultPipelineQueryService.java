package me.anichakra.poc.pilot.heloc.pipeline.service.impl;

import java.util.List;

import javax.inject.Inject;

import me.anichakra.poc.pilot.framework.annotation.Event;
import me.anichakra.poc.pilot.framework.annotation.QueryService;
import me.anichakra.poc.pilot.heloc.pipeline.domain.Condition;
import me.anichakra.poc.pilot.heloc.pipeline.domain.FollowUp;
import me.anichakra.poc.pilot.heloc.pipeline.repo.ConditionRepository;
import me.anichakra.poc.pilot.heloc.pipeline.repo.FollowUpRepository;
import me.anichakra.poc.pilot.heloc.pipeline.service.PipelineQueryService;

@QueryService
public class DefaultPipelineQueryService implements PipelineQueryService {

	@Inject
	private ConditionRepository conditionRepository;

	@Inject
	private FollowUpRepository followUpRepository;

	@Override
	@Event(name = "tracing")
	public List<Condition> getConditions(Long applicationId) {
		return conditionRepository.findByApplicationId(applicationId);
	}

	@Override
	@Event(name = "tracing")
	public List<FollowUp> getFollowUps(Long applicationId) {
		return followUpRepository.findByApplicationId(applicationId);
	}

	@Override
	@Event(name = "tracing")
	public List<FollowUp> getPendingFollowUps() {
		return followUpRepository.findByCompletedFalse();
	}
}
