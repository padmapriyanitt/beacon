package org.apache.beacon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {
	
	@Autowired
	private PolicyScheduler policyScheduler;
	@Scheduled(fixedDelay = 60000)
	public void runPolicies() {
		policyScheduler.schedulePolicies();
	}
}
