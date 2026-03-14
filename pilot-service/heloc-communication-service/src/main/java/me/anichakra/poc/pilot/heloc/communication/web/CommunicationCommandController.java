package me.anichakra.poc.pilot.heloc.communication.web;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import me.anichakra.poc.pilot.heloc.communication.domain.ChatMessage;
import me.anichakra.poc.pilot.heloc.communication.domain.FollowUpReminder;
import me.anichakra.poc.pilot.heloc.communication.domain.Notification;
import me.anichakra.poc.pilot.heloc.communication.service.CommunicationCommandService;

@RestController
public class CommunicationCommandController {

	@Inject
	private CommunicationCommandService communicationCommandService;

	@PostMapping("/chat/send")
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public ChatMessage sendMessage(@RequestBody ChatMessage message) {
		return communicationCommandService.sendMessage(message);
	}

	@PostMapping("/notification/send")
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Notification sendNotification(@RequestBody Notification notification) {
		return communicationCommandService.sendNotification(notification);
	}

	@PostMapping("/followup/create")
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public FollowUpReminder createFollowUpReminder(@RequestBody FollowUpReminder reminder) {
		return communicationCommandService.createFollowUpReminder(reminder);
	}

	@PostMapping("/followup/{id}/complete")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public FollowUpReminder markReminderComplete(@PathVariable("id") String id) {
		return communicationCommandService.markReminderComplete(id);
	}
}
