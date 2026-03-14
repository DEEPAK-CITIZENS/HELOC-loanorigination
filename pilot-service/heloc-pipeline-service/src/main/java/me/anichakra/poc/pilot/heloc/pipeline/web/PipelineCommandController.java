package me.anichakra.poc.pilot.heloc.pipeline.web;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import me.anichakra.poc.pilot.heloc.pipeline.domain.Condition;
import me.anichakra.poc.pilot.heloc.pipeline.domain.FollowUp;
import me.anichakra.poc.pilot.heloc.pipeline.service.PipelineCommandService;

@RestController
@RequestMapping("/pipeline")
public class PipelineCommandController {

	@Inject
	private PipelineCommandService pipelineCommandService;

	@PostMapping("/{applicationId}/condition")
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Condition createCondition(@PathVariable("applicationId") Long applicationId, @RequestBody Condition condition) {
		condition.setApplicationId(applicationId);
		return pipelineCommandService.createCondition(condition);
	}

	@PutMapping("/condition/{id}/status")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Condition updateConditionStatus(@PathVariable("id") Long id, @RequestParam("status") String status) {
		return pipelineCommandService.updateConditionStatus(id, status);
	}

	@PostMapping("/{applicationId}/followup")
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public FollowUp createFollowUp(@PathVariable("applicationId") Long applicationId, @RequestBody FollowUp followUp) {
		followUp.setApplicationId(applicationId);
		return pipelineCommandService.createFollowUp(followUp);
	}
}
