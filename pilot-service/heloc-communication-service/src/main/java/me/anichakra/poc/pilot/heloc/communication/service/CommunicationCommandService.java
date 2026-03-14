package me.anichakra.poc.pilot.heloc.communication.service;

import me.anichakra.poc.pilot.heloc.communication.domain.ChatMessage;
import me.anichakra.poc.pilot.heloc.communication.domain.FollowUpReminder;
import me.anichakra.poc.pilot.heloc.communication.domain.Notification;

public interface CommunicationCommandService {

	ChatMessage sendMessage(ChatMessage message);

	Notification sendNotification(Notification notification);

	FollowUpReminder createFollowUpReminder(FollowUpReminder reminder);

	FollowUpReminder markReminderComplete(String reminderId);
}
