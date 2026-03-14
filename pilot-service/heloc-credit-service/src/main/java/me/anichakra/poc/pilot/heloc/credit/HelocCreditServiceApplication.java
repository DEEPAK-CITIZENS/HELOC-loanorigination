package me.anichakra.poc.pilot.heloc.credit;

import me.anichakra.poc.pilot.framework.annotation.Microservice;
import me.anichakra.poc.pilot.framework.rest.config.EnableRestConsumers;
import me.anichakra.poc.pilot.framework.web.MicroserviceApplication;

@Microservice
@EnableRestConsumers
public class HelocCreditServiceApplication {

	public static void main(String[] args) {
		MicroserviceApplication.start(args);
	}
}
