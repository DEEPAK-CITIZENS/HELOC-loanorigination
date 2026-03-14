package me.anichakra.poc.pilot.heloc.pipeline.web;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import me.anichakra.poc.pilot.heloc.pipeline.domain.Condition;
import me.anichakra.poc.pilot.heloc.pipeline.domain.FollowUp;
import me.anichakra.poc.pilot.heloc.pipeline.service.PipelineQueryService;

@RestController
@RequestMapping("/pipeline")
public class PipelineQueryController {

	@Inject
	private PipelineQueryService pipelineQueryService;

	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/{applicationId}/conditions")
	@ResponseBody
	public List<Condition> getConditions(@PathVariable("applicationId") Long applicationId) {
		return pipelineQueryService.getConditions(applicationId);
	}

	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/{applicationId}/followups")
	@ResponseBody
	public List<FollowUp> getFollowUps(@PathVariable("applicationId") Long applicationId) {
		return pipelineQueryService.getFollowUps(applicationId);
	}

	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/followups/pending")
	@ResponseBody
	public List<FollowUp> getPendingFollowUps() {
		return pipelineQueryService.getPendingFollowUps();
	}
}
