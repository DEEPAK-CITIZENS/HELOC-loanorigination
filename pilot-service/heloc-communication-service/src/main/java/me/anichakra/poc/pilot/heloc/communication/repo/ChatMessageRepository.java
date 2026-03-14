package me.anichakra.poc.pilot.heloc.communication.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import me.anichakra.poc.pilot.heloc.communication.domain.ChatMessage;

@Repository
public interface ChatMessageRepository extends MongoRepository<ChatMessage, String> {

	List<ChatMessage> findByApplicationId(Long applicationId);
}
