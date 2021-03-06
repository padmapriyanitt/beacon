package org.apache.beacon.dao;

import java.io.Serializable;

import org.apache.beacon.domain.Policy;
import org.springframework.data.repository.CrudRepository;

public interface PolicyDao extends CrudRepository<Policy, Serializable> {
	
	Policy findByName(String policyName);
	
	Iterable<Policy> findBySourceCluster(String clusterName);
	
	Iterable<Policy> findByTargetCluster(String clusterName);
}
