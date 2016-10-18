package org.apache.beacon.web;

import java.util.HashMap;
import java.util.Map;

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
@RequestMapping("/api/beacon/policy")
public class PolicyController {
	@Autowired
	private BeaconService beaconService;
	
	@RequestMapping(value = "submit/{policyName}", method = RequestMethod.POST)
	public @ResponseBody Map <String,Object> submitPolicy(
			@PathVariable("policyName") String name,
			@RequestBody Policy policy) {
		beaconService.submitPolicy(policy,name);
		HashMap <String,Object> resp=new HashMap<>();
		resp.put("requestId","qtp2026718042"+Math.random());
		resp.put("message","Submit successf(Policy) ");
		resp.put("status","SUCCEEDED");
		return resp;
	}
	@RequestMapping(value = "schedule/{policyName}", method = RequestMethod.POST)
	public @ResponseBody Map<String,Object> submitPolicy(@PathVariable("policyName") String name){
		//TODO implementation
		HashMap <String,Object> resp=new HashMap<>();
		resp.put("requestId","qtp2026718042"+Math.random());
		resp.put("message","Schedule successf(Policy) ");
		resp.put("status","SUCCEEDED");
		return resp;
	}
	@RequestMapping(value = "submitAndSchedule/{policyName}", method = RequestMethod.POST)
	public @ResponseBody Map<String,Object> submitAndSchedule(@PathVariable("policyName") String name){
		//TODO implementation
		HashMap <String,Object> resp=new HashMap<>();
		resp.put("requestId","qtp2026718042"+Math.random());
		resp.put("message","Schedule successf(Policy) ");
		resp.put("status","SUCCEEDED");
		return resp;
	}
	
	@RequestMapping(value = "status/{policyName}", method = RequestMethod.GET)
	public @ResponseBody Map<String,Object> getStatus(@PathVariable("policyName") String name){
		//TODO implementation
		HashMap <String,Object> resp=new HashMap<>();
		resp.put("requestId","qtp2026718042"+Math.random());
		resp.put("message","Schedule successf(Policy) ");
		resp.put("status","SUCCEEDED");
		return resp;
	}
	@RequestMapping(value = "get/{policyName}", method = RequestMethod.GET)
	public @ResponseBody Policy getPolicy(@PathVariable("policyName") String name){
		Policy policy = beaconService.getPolicy(name);
		return policy;
	}
	@RequestMapping(value = "delete/{policyName}", method = RequestMethod.DELETE)
	public @ResponseBody Map deletePolicy(@PathVariable("policyName") String name){
		HashMap <String,String> resp=new HashMap<>();
		beaconService.deltetePolicy(name);
		resp.put("requestId","qtp2026718042"+Math.random());
		resp.put("message","Policy deleted(Policy) ");
		resp.put("status","SUCCEEDED");
		return resp;
	}
	
	@RequestMapping("list")
	public @ResponseBody Iterable<Policy> getPolicies() {
		return beaconService.getAllPolicies();
	}

}