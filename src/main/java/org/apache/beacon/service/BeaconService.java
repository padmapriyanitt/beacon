package org.apache.beacon.service;

import javax.transaction.Transactional;

import org.apache.beacon.dao.ClusterDao;
import org.apache.beacon.dao.PolicyDao;
import org.apache.beacon.domain.Cluster;
import org.apache.beacon.domain.Policy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class BeaconService {

	@Autowired
	private ClusterDao clusterDao;

	@Autowired
	private PolicyDao policyDao;

	public Iterable<Cluster> getAllClusters() {
		return clusterDao.findAll();
	}

	public Cluster register(Cluster cluster) {
		return clusterDao.save(cluster);
	}

	public Cluster getCluster(String clusterName) {
		return clusterDao.findByName(clusterName);
	}

	public Iterable<Policy> getAllPolicies() {
		return policyDao.findAll();
	}

	public Policy savePolicy(Policy policy) {
		return policyDao.save(policy);
	}

	public String query(String sql) {
		// TODO Auto-generated method stub
		return null;
	}
}
