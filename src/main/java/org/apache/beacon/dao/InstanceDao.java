package org.apache.beacon.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.beacon.domain.Instance;
import org.springframework.data.repository.CrudRepository;

public interface InstanceDao extends CrudRepository<Instance, Serializable> {
	List<Instance> findByPolicyId(Long id);
}
