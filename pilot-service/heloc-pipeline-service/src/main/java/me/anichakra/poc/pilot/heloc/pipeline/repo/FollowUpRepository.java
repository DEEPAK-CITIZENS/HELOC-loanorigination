package me.anichakra.poc.pilot.heloc.pipeline.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.anichakra.poc.pilot.heloc.pipeline.domain.FollowUp;

@Repository
public interface FollowUpRepository extends JpaRepository<FollowUp, Long> {

	List<FollowUp> findByApplicationId(Long applicationId);

	List<FollowUp> findByCompletedFalse();

	List<FollowUp> findByAssignedToAndCompletedFalse(String assignedTo);
}
