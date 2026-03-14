package me.anichakra.poc.pilot.heloc.communication.service.impl;

import java.util.Date;

import javax.inject.Inject;

import me.anichakra.poc.pilot.framework.annotation.CommandService;
import me.anichakra.poc.pilot.framework.annotation.Event;
import me.anichakra.poc.pilot.framework.annotation.EventObject;
import me.anichakra.poc.pilot.heloc.communication.domain.ChatMessage;
import me.anichakra.poc.pilot.heloc.communication.domain.FollowUpReminder;
import me.anichakra.poc.pilot.heloc.communication.domain.Notification;
import me.anichakra.poc.pilot.heloc.communication.repo.ChatMessageRepository;
import me.anichakra.poc.pilot.heloc.communication.repo.FollowUpReminderRepository;
import me.anichakra.poc.pilot.heloc.communication.repo.NotificationRepository;
import me.anichakra.poc.pilot.heloc.communication.service.CommunicationCommandService;

@CommandService
public class DefaultCommunicationCommandService implements CommunicationCommandService {

	@Inject
	private ChatMessageRepository chatMessageRepository;

	@Inject
	private NotificationRepository notificationRepository;

	@Inject
	private FollowUpReminderRepository followUpReminderRepository;

	@Override
	@Event(name = "sourcing", object = EventObject.RESPONSE)
	public ChatMessage sendMessage(ChatMessage message) {
		message.setTimestamp(new Date());
		return chatMessageRepository.save(message);
	}

	@Override
	@Event(name = "sourcing", object = EventObject.RESPONSE)
	public Notification sendNotification(Notification notification) {
		notification.setSentDate(new Date());
		notification.setStatus("SENT");
		return notificationRepository.save(notification);
	}

	@Override
	@Event(name = "sourcing", object = EventObject.RESPONSE)
	public FollowUpReminder createFollowUpReminder(FollowUpReminder reminder) {
		reminder.setCompleted(false);
		return followUpReminderRepository.save(reminder);
	}

	@Override
	@Event(name = "sourcing", object = EventObject.RESPONSE)
	public FollowUpReminder markReminderComplete(String reminderId) {
		FollowUpReminder reminder = followUpReminderRepository.findById(reminderId).get();
		reminder.setCompleted(true);
		return followUpReminderRepository.save(reminder);
	}
}
