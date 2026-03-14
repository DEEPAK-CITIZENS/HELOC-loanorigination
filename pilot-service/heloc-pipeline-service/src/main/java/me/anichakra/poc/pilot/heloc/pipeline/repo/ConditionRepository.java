package me.anichakra.poc.pilot.heloc.pipeline.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.anichakra.poc.pilot.heloc.pipeline.domain.Condition;

@Repository
public interface ConditionRepository extends JpaRepository<Condition, Long> {

	List<Condition> findByApplicationId(Long applicationId);
}
