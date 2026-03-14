package me.anichakra.poc.pilot.heloc.communication.web;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import me.anichakra.poc.pilot.heloc.communication.domain.ChatMessage;
import me.anichakra.poc.pilot.heloc.communication.domain.FollowUpReminder;
import me.anichakra.poc.pilot.heloc.communication.domain.Notification;
import me.anichakra.poc.pilot.heloc.communication.service.CommunicationQueryService;

@RestController
public class CommunicationQueryController {

	@Inject
	private CommunicationQueryService communicationQueryService;

	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/chat/history/{applicationId}")
	@ResponseBody
	public List<ChatMessage> getChatHistory(@PathVariable("applicationId") Long applicationId) {
		return communicationQueryService.getChatHistory(applicationId);
	}

	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/notification/{recipientId}")
	@ResponseBody
	public List<Notification> getNotifications(@PathVariable("recipientId") String recipientId) {
		return communicationQueryService.getNotifications(recipientId);
	}

	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/followup/pending/{userId}")
	@ResponseBody
	public List<FollowUpReminder> getPendingReminders(@PathVariable("userId") String userId) {
		return communicationQueryService.getPendingReminders(userId);
	}
}
