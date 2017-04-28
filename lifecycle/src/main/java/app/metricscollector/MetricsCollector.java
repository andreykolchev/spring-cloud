package app.metricscollector;

import app.decisionengine.DecisionEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
public class MetricsCollector{
	@Autowired
    DiscoveryClient eurekaClient;
	
	@Autowired
	DecisionEngine decisionEngine;
	
	@Autowired
 	private RestTemplate restTemplate;
	
	public void start(){
		while(true){ 
			eurekaClient.getServices().forEach(service -> {		
				System.out.println("printing service "+ service);
				Map metrics = restTemplate.getForObject("http://"+service+"/metrics",Map.class);
				decisionEngine.execute(service, metrics);
			});	
		}		
	}
}

