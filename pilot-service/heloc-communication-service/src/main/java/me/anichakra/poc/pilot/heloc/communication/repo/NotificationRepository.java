package me.anichakra.poc.pilot.heloc.communication.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import me.anichakra.poc.pilot.heloc.communication.domain.Notification;

@Repository
public interface NotificationRepository extends MongoRepository<Notification, String> {

	List<Notification> findByRecipientId(String recipientId);
}
