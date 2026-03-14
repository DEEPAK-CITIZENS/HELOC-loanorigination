package me.anichakra.poc.pilot.heloc.application;

import me.anichakra.poc.pilot.framework.annotation.Microservice;
import me.anichakra.poc.pilot.framework.web.MicroserviceApplication;

@Microservice
public class HelocApplicationServiceApplication {

	public static void main(String[] args) {
		MicroserviceApplication.start(args);
	}
}
