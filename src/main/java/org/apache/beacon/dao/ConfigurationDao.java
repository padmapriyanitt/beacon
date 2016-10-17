package org.apache.beacon.dao;

import java.io.Serializable;

import javax.transaction.Transactional;

import org.apache.beacon.domain.Cluster;
import org.apache.beacon.domain.Configuration;
import org.springframework.data.repository.CrudRepository;

@Transactional
public interface ConfigurationDao extends CrudRepository<Cluster, Serializable>{
	public Configuration findByName(String name);
}
