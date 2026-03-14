package me.anichakra.poc.pilot.heloc.document.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import me.anichakra.poc.pilot.heloc.document.domain.Document;

@Repository
public interface DocumentRepository extends MongoRepository<Document, String> {

	List<Document> findByApplicationId(Long applicationId);
}
