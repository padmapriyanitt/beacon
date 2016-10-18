package org.apache.beacon.web;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.beacon.domain.Cluster;
import org.apache.beacon.domain.Pair;
import org.apache.beacon.service.BeaconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/beacon")
public class BeaconController {

	@Autowired
	private BeaconService beaconkService;


	@RequestMapping(value = "cluster/submit/{clusterName}", method = RequestMethod.POST)
	public @ResponseBody Map<String,Object> registerCluster(
			@PathVariable("clusterName") String name,
			@RequestBody Cluster cluster) {
		Cluster createdCluster = beaconkService.register(cluster);
		HashMap <String,Object> resp=new HashMap<>();
		resp.put("requestId","qtp2026718042"+Math.random());
		resp.put("message","Submit successf(Cluster) ");
		resp.put("status","SUCCEEDED");
		return resp;
	}
	
	@RequestMapping("cluster/list")
	public @ResponseBody Map<String,Object> getClusters() {
		Iterable<Cluster> allClusters = beaconkService.getAllClusters();
		HashMap<String,Object> resp=new HashMap<>();
		resp.put("totalResults", getIterableSize(allClusters));
		resp.put("entity",allClusters);
		return resp;
	}

	@RequestMapping("cluster/status/{clusterName}")
	public @ResponseBody Map<String,Object> getClusterStatus(
			@PathVariable("clusterName") String clusterName) {
		//TODO implement...
		HashMap <String,Object> resp=new HashMap<>();
		resp.put("requestId","qtp2026718042"+Math.random());
		return resp;
	}

	@RequestMapping("cluster/get/{clusterName}")
	public @ResponseBody Cluster getClusterInfo(
			@PathVariable("clusterName") String clusterName) {
		return beaconkService.getCluster(clusterName);
	}
	
	
	@RequestMapping(value = "cluster/delete/{clusterName}",method = RequestMethod.DELETE)
	public @ResponseBody Map<String,String> deleteCluster(@PathVariable("clusterName") String name) {
		//TODO implement
		return null;
	}
	
	@RequestMapping(value = "pair",method = RequestMethod.POST)
	public @ResponseBody Map<String,String> setPeer(Pair pair) {
		beaconkService.pair(pair);
		HashMap <String,String> resp=new HashMap<>();
		resp.put("requestId","qtp2026718042"+Math.random());
		resp.put("message","Clusters successfully paired");
		resp.put("status","SUCCEEDED");
		return resp;
	}
	
	private long getIterableSize(Iterable values) {
		if (values==null){
			return 0;
		}
		if (values instanceof Collection<?>) {
			return ((Collection<?>) values).size();
		}
		long size = 0L;
		for (Object value : values) {
			size++;
		}
		return size;
	}

}
