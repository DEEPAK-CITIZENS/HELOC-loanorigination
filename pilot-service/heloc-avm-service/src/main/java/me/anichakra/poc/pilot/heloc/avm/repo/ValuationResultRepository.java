package me.anichakra.poc.pilot.heloc.avm.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.anichakra.poc.pilot.heloc.avm.domain.ValuationResult;

@Repository
public interface ValuationResultRepository extends JpaRepository<ValuationResult, Long> {

	List<ValuationResult> findByPropertyAddress(String propertyAddress);
}
