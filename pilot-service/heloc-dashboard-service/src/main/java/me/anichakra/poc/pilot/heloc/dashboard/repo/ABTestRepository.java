package me.anichakra.poc.pilot.heloc.dashboard.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.anichakra.poc.pilot.heloc.dashboard.domain.ABTest;

@Repository
public interface ABTestRepository extends JpaRepository<ABTest, Long> {

	List<ABTest> findByStatus(String status);
}
