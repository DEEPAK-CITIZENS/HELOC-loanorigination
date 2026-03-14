package me.anichakra.poc.pilot.heloc.cosigner.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.anichakra.poc.pilot.heloc.cosigner.domain.Cosigner;

@Repository
public interface CosignerRepository extends JpaRepository<Cosigner, Long> {

	List<Cosigner> findByPrimaryApplicationId(Long primaryApplicationId);
}
