package me.anichakra.poc.pilot.heloc.pipeline.service;

import me.anichakra.poc.pilot.heloc.pipeline.domain.Condition;
import me.anichakra.poc.pilot.heloc.pipeline.domain.FollowUp;

public interface PipelineCommandService {

	Condition createCondition(Condition condition);

	Condition updateConditionStatus(Long conditionId, String status);

	FollowUp createFollowUp(FollowUp followUp);

	FollowUp updateFollowUp(FollowUp followUp);
}
