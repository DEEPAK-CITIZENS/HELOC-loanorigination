package me.anichakra.poc.pilot.heloc.dashboard;

import me.anichakra.poc.pilot.framework.annotation.Microservice;
import me.anichakra.poc.pilot.framework.web.MicroserviceApplication;

@Microservice
public class HelocDashboardServiceApplication {

	public static void main(String[] args) {
		MicroserviceApplication.start(args);
	}
}
