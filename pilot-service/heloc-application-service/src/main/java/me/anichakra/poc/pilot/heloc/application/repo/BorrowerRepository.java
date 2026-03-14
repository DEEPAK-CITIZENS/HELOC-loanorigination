package me.anichakra.poc.pilot.heloc.application.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.anichakra.poc.pilot.heloc.application.domain.Borrower;

@Repository
public interface BorrowerRepository extends JpaRepository<Borrower, Long> {
}
