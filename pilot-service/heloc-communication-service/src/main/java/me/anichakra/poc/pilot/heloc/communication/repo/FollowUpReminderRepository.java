package me.anichakra.poc.pilot.heloc.communication.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import me.anichakra.poc.pilot.heloc.communication.domain.FollowUpReminder;

@Repository
public interface FollowUpReminderRepository extends MongoRepository<FollowUpReminder, String> {

	List<FollowUpReminder> findByAssignedToAndCompletedFalse(String assignedTo);

	List<FollowUpReminder> findByApplicationId(Long applicationId);
}
