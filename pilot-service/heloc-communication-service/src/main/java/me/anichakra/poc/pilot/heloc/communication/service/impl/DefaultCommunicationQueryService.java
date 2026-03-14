package me.anichakra.poc.pilot.heloc.communication.service.impl;

import java.util.List;

import javax.inject.Inject;

import me.anichakra.poc.pilot.framework.annotation.Event;
import me.anichakra.poc.pilot.framework.annotation.QueryService;
import me.anichakra.poc.pilot.heloc.communication.domain.ChatMessage;
import me.anichakra.poc.pilot.heloc.communication.domain.FollowUpReminder;
import me.anichakra.poc.pilot.heloc.communication.domain.Notification;
import me.anichakra.poc.pilot.heloc.communication.repo.ChatMessageRepository;
import me.anichakra.poc.pilot.heloc.communication.repo.FollowUpReminderRepository;
import me.anichakra.poc.pilot.heloc.communication.repo.NotificationRepository;
import me.anichakra.poc.pilot.heloc.communication.service.CommunicationQueryService;

@QueryService
public class DefaultCommunicationQueryService implements CommunicationQueryService {

	@Inject
	private ChatMessageRepository chatMessageRepository;

	@Inject
	private NotificationRepository notificationRepository;

	@Inject
	private FollowUpReminderRepository followUpReminderRepository;

	@Override
	@Event(name = "tracing")
	public List<ChatMessage> getChatHistory(Long applicationId) {
		return chatMessageRepository.findByApplicationId(applicationId);
	}

	@Override
	@Event(name = "tracing")
	public List<Notification> getNotifications(String recipientId) {
		return notificationRepository.findByRecipientId(recipientId);
	}

	@Override
	@Event(name = "tracing")
	public List<FollowUpReminder> getPendingReminders(String userId) {
		return followUpReminderRepository.findByAssignedToAndCompletedFalse(userId);
	}
}
