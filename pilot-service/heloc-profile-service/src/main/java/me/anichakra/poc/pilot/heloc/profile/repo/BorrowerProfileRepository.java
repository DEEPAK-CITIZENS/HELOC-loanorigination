package me.anichakra.poc.pilot.heloc.profile.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.anichakra.poc.pilot.heloc.profile.domain.BorrowerProfile;

@Repository
public interface BorrowerProfileRepository extends JpaRepository<BorrowerProfile, Long> {

	List<BorrowerProfile> findByLastName(String lastName);
}
