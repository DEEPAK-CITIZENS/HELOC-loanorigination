package me.anichakra.poc.pilot.heloc.credit.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.anichakra.poc.pilot.heloc.credit.domain.CreditReport;

@Repository
public interface CreditReportRepository extends JpaRepository<CreditReport, Long> {

	Optional<CreditReport> findByApplicationId(Long applicationId);
}
