package me.anichakra.poc.pilot.heloc.credit.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.anichakra.poc.pilot.heloc.credit.domain.CreditDecision;

@Repository
public interface CreditDecisionRepository extends JpaRepository<CreditDecision, Long> {

	Optional<CreditDecision> findByApplicationId(Long applicationId);
}
