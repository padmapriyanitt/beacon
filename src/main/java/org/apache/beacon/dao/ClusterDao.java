package org.apache.beacon.dao;

import java.io.Serializable;

import javax.transaction.Transactional;

import org.apache.beacon.domain.Cluster;
import org.springframework.data.repository.CrudRepository;

@Transactional
public interface ClusterDao extends CrudRepository<Cluster, Serializable> {

	public Cluster findByName(String clusterName);
}
