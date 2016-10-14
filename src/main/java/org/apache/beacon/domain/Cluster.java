package org.apache.beacon.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clusters")
public class Cluster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "colo")
	private String colo;
	
	@Column(name = "name_node_uri")
	private String nameNodeUri;
	
	@Column(name = "execute_uri")
	private String executeUri;
	
	@Column(name = "wf_engine_uri")
	private String wfEngineUri;
	
	@Column(name = "messaging_uri")
	private String messagingUri;
	
	@Column(name = "hs2_uri")
	private String hs2Uri;
	
	@Column(name = "tags")
	private String tags;
	
	@Column(name = "custom_properties")
	private String customProperties;
	
	@Column(name = "acl")
	private String acl;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getColo() {
		return colo;
	}

	public void setColo(String colo) {
		this.colo = colo;
	}

	public String getNameNodeUri() {
		return nameNodeUri;
	}

	public void setNameNodeUri(String nameNodeUri) {
		this.nameNodeUri = nameNodeUri;
	}

	public String getExecuteUri() {
		return executeUri;
	}

	public void setExecuteUri(String executeUri) {
		this.executeUri = executeUri;
	}

	public String getWfEngineUri() {
		return wfEngineUri;
	}

	public void setWfEngineUri(String wfEngineUri) {
		this.wfEngineUri = wfEngineUri;
	}

	public String getMessagingUri() {
		return messagingUri;
	}

	public void setMessagingUri(String messagingUri) {
		this.messagingUri = messagingUri;
	}

	public String getHs2Uri() {
		return hs2Uri;
	}

	public void setHs2Uri(String hs2Uri) {
		this.hs2Uri = hs2Uri;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getCustomProperties() {
		return customProperties;
	}

	public void setCustomProperties(String customProperties) {
		this.customProperties = customProperties;
	}

	public String getAcl() {
		return acl;
	}

	public void setAcl(String acl) {
		this.acl = acl;
	}
}
