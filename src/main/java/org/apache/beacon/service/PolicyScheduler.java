package org.apache.beacon.service;

import javax.transaction.Transactional;

import org.apache.beacon.JobStatus;
import org.apache.beacon.dao.ConfigurationDao;
import org.apache.beacon.dao.InstanceDao;
import org.apache.beacon.dao.PolicyDao;
import org.apache.beacon.domain.Instance;
import org.apache.beacon.domain.Policy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PolicyScheduler {

	@Autowired
	private PolicyDao policyDao;

	@Autowired
	private InstanceDao instanceDao;

	@Autowired
	private ConfigurationDao configurationDao;

	public void schedule(String name) {
		Policy policy = policyDao.findByName(name);
		Instance inst = new Instance();
		inst.setPolicyId(policy.getId());
		inst.setStatus(JobStatus.RUNNING.name());
		instanceDao.save(inst);

	}

	public void schedulePolicies() {
		Iterable<Policy> allPolicies = policyDao.findAll();
		for (Policy policy:allPolicies){
			
		}
	}

}
