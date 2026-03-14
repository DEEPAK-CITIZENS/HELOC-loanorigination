package me.anichakra.poc.pilot.heloc.application.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.anichakra.poc.pilot.heloc.application.domain.LoanApplication;

@Repository
public interface ApplicationRepository extends JpaRepository<LoanApplication, Long> {

	List<LoanApplication> findByBorrowerId(Long borrowerId);
}
