package me.anichakra.poc.pilot.heloc.communication.service;

import java.util.List;

import me.anichakra.poc.pilot.heloc.communication.domain.ChatMessage;
import me.anichakra.poc.pilot.heloc.communication.domain.FollowUpReminder;
import me.anichakra.poc.pilot.heloc.communication.domain.Notification;

public interface CommunicationQueryService {

	List<ChatMessage> getChatHistory(Long applicationId);

	List<Notification> getNotifications(String recipientId);

	List<FollowUpReminder> getPendingReminders(String userId);
}
