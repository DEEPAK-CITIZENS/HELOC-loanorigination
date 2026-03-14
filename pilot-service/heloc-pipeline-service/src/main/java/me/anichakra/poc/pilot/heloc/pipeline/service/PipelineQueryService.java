package me.anichakra.poc.pilot.heloc.pipeline.service;

import java.util.List;

import me.anichakra.poc.pilot.heloc.pipeline.domain.Condition;
import me.anichakra.poc.pilot.heloc.pipeline.domain.FollowUp;

public interface PipelineQueryService {

	List<Condition> getConditions(Long applicationId);

	List<FollowUp> getFollowUps(Long applicationId);

	List<FollowUp> getPendingFollowUps();
}
