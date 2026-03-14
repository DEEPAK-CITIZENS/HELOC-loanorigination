package me.anichakra.poc.pilot.heloc.pipeline.service.impl;

import javax.inject.Inject;

import me.anichakra.poc.pilot.framework.annotation.CommandService;
import me.anichakra.poc.pilot.framework.annotation.Event;
import me.anichakra.poc.pilot.framework.annotation.EventObject;
import me.anichakra.poc.pilot.heloc.pipeline.domain.Condition;
import me.anichakra.poc.pilot.heloc.pipeline.domain.FollowUp;
import me.anichakra.poc.pilot.heloc.pipeline.repo.ConditionRepository;
import me.anichakra.poc.pilot.heloc.pipeline.repo.FollowUpRepository;
import me.anichakra.poc.pilot.heloc.pipeline.service.PipelineCommandService;

@CommandService
public class DefaultPipelineCommandService implements PipelineCommandService {

	@Inject
	private ConditionRepository conditionRepository;

	@Inject
	private FollowUpRepository followUpRepository;

	@Override
	@Event(name = "sourcing", object = EventObject.RESPONSE)
	public Condition createCondition(Condition condition) {
		condition.setStatus("PENDING");
		return conditionRepository.saveAndFlush(condition);
	}

	@Override
	@Event(name = "sourcing", object = EventObject.RESPONSE)
	public Condition updateConditionStatus(Long conditionId, String status) {
		Condition condition = conditionRepository.findById(conditionId).get();
		condition.setStatus(status);
		return conditionRepository.saveAndFlush(condition);
	}

	@Override
	@Event(name = "sourcing", object = EventObject.RESPONSE)
	public FollowUp createFollowUp(FollowUp followUp) {
		followUp.setCompleted(false);
		return followUpRepository.saveAndFlush(followUp);
	}

	@Override
	@Event(name = "sourcing", object = EventObject.RESPONSE)
	public FollowUp updateFollowUp(FollowUp followUp) {
		return followUpRepository.saveAndFlush(followUp);
	}
}
