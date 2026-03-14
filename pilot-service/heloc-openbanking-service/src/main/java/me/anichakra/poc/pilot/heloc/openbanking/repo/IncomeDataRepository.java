package me.anichakra.poc.pilot.heloc.openbanking.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.anichakra.poc.pilot.heloc.openbanking.domain.IncomeData;

@Repository
public interface IncomeDataRepository extends JpaRepository<IncomeData, Long> {
}
