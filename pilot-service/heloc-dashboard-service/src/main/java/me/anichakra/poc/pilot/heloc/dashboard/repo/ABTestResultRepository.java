package me.anichakra.poc.pilot.heloc.dashboard.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.anichakra.poc.pilot.heloc.dashboard.domain.ABTestResult;

@Repository
public interface ABTestResultRepository extends JpaRepository<ABTestResult, Long> {

	List<ABTestResult> findByTestId(Long testId);
}
