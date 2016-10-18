package org.apache.beacon.service;

import java.util.ArrayList;
import java.util.Set;

import javax.transaction.Transactional;

import org.apache.beacon.dao.ClusterDao;
import org.apache.beacon.dao.ConfigurationDao;
import org.apache.beacon.dao.PolicyDao;
import org.apache.beacon.domain.Cluster;
import org.apache.beacon.domain.Configuration;
import org.apache.beacon.domain.Pair;
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

	@Autowired
	private ConfigurationDao configurationDao;

	public Iterable<Cluster> getAllClusters() {
		Iterable<Cluster> clusters = clusterDao.findAll();
		if (clusters != null) {
			for (Cluster cl : clusters) {
				setPeerClusters(cl);
			}
		}
		return clusters;
	}

	private void setPeerClusters(Cluster cl) {
		ArrayList<String> peerClusters = new ArrayList<>();
		Set<Cluster> peers = cl.getPeers();
		for (Cluster peer : peers) {
			peerClusters.add(peer.getName());
		}
		cl.setClusterNames(peerClusters);
	}

	public Cluster register(Cluster cluster) {
		return clusterDao.save(cluster);
	}

	public Cluster getCluster(String clusterName) {
		Cluster cluster = clusterDao.findByName(clusterName);
		setPeerClusters(cluster);
		return cluster;
	}

	public Iterable<Policy> getAllPolicies() {
		return policyDao.findAll();
	}

	public Policy savePolicy(Policy policy) {
		return policyDao.save(policy);
	}

	public void pair(Pair pair) {
		Cluster sourceCluster = getSourceCluster();
		Cluster targetCluster = clusterDao.findByName(pair.getName());
		sourceCluster.getPeers().add(targetCluster);
		clusterDao.save(sourceCluster);
	}

	private Cluster getSourceCluster() {
		Configuration configuration = configurationDao
				.findByName("source_cluster");
		if (configuration == null) {
			throw new RuntimeException(
					"Source Cluster not configured in configuraiton");
		}
		String sourceClusterName = configuration.getValue();
		Cluster sourceCluster = clusterDao.findByName(sourceClusterName);
		return sourceCluster;
	}

	public void deltetePolicy(String name) {
		Policy policy = policyDao.findByName(name);
		policyDao.delete(policy);
	}

	public Policy getPolicy(String name) {
		return policyDao.findByName(name);
	}

	public void submitPolicy(Policy policy, String name) {
		Policy exitingPolicy = policyDao.findByName(name);
		if (exitingPolicy != null) {
			throw new RuntimeException("Policy already exists");
		}
		policyDao.save(policy);

	}
}
