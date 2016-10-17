package org.apache.beacon.web;

import org.apache.beacon.domain.Cluster;
import org.apache.beacon.domain.Policy;
import org.apache.beacon.service.BeaconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BeaconController {

	@Autowired
	private BeaconService beaconkService;

	@RequestMapping("/cluster/list")
	public @ResponseBody Iterable<Cluster> getClusters() {
		return beaconkService.getAllClusters();
	}

	@RequestMapping(value = "/cluster/submit/{clusterName}", method = RequestMethod.POST)
	public @ResponseBody Cluster registerCluster(
			@PathVariable("clusterName") String name,
			@RequestBody Cluster cluster) {
		return beaconkService.register(cluster);
	}

	@RequestMapping("/cluster/get/{clusterName}")
	public @ResponseBody Cluster getClusterInfo(
			@PathVariable("clusterName") String clusterName) {
		return beaconkService.getCluster(clusterName);
	}

	@RequestMapping("/policy/list")
	public @ResponseBody Iterable<Policy> getPolicies() {
		return beaconkService.getAllPolicies();
	}
	@RequestMapping(value = "/cluster/pair",method = RequestMethod.POST)
	public @ResponseBody String setPeer() {
		
		return null;
	}
	
	
	@RequestMapping("/admin/query")
	public @ResponseBody String query(@RequestBody String sql) {
		return beaconkService.query(sql);
	}
}
