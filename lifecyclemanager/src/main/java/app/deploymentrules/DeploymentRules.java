package app.deploymentrules;

import org.springframework.stereotype.Component;

@Component
public class DeploymentRules{
	public DeploymentRule getDeploymentRules(String serviceId){
		return new DummyDeploymentRule();
	}
}