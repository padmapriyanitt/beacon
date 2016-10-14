package org.apache.beacon.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "policies")
public class Policy {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "type")
	private String type;

	@Column(name = "dataset")
	private String dataset;

	@Column(name = "sourceCluster")
	private String sourceCluster;

	@Column(name = "targetCluster")
	private String targetCluster;

	@Column(name = "frequencyInSec")
	private long frequencyInSec;

	@Column(name = "tags")
	private String tags;

	@Column(name = "component")
	private String component;

	@Column(name = "aclOwner")
	private String aclOwner;

	@Column(name = "aclGroup")
	private String aclGroup;

	@Column(name = "aclPermission")
	private String aclPermission;

	@Column(name = "retryAttempts")
	private int retryAttempts;

	@Column(name = "queue")
	private String queue;

	@Column(name = "maxEvents")
	private int maxEvents;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDataset() {
		return dataset;
	}

	public void setDataset(String dataset) {
		this.dataset = dataset;
	}

	public String getSourceCluster() {
		return sourceCluster;
	}

	public void setSourceCluster(String sourceCluster) {
		this.sourceCluster = sourceCluster;
	}

	public String getTargetCluster() {
		return targetCluster;
	}

	public void setTargetCluster(String targetCluster) {
		this.targetCluster = targetCluster;
	}

	public long getFrequencyInSec() {
		return frequencyInSec;
	}

	public void setFrequencyInSec(long frequencyInSec) {
		this.frequencyInSec = frequencyInSec;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getComponent() {
		return component;
	}

	public void setComponent(String component) {
		this.component = component;
	}

	public String getAclOwner() {
		return aclOwner;
	}

	public void setAclOwner(String aclOwner) {
		this.aclOwner = aclOwner;
	}

	public String getAclGroup() {
		return aclGroup;
	}

	public void setAclGroup(String aclGroup) {
		this.aclGroup = aclGroup;
	}

	public String getAclPermission() {
		return aclPermission;
	}

	public void setAclPermission(String aclPermission) {
		this.aclPermission = aclPermission;
	}

	public int getRetryAttempts() {
		return retryAttempts;
	}

	public void setRetryAttempts(int retryAttempts) {
		this.retryAttempts = retryAttempts;
	}

	public String getQueue() {
		return queue;
	}

	public void setQueue(String queue) {
		this.queue = queue;
	}

	public int getMaxEvents() {
		return maxEvents;
	}

	public void setMaxEvents(int maxEvents) {
		this.maxEvents = maxEvents;
	}

}
