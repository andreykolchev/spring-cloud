package app.decisionengine;

import app.deploymentengine.DeploymentEngine;
import app.deploymentrules.DeploymentRules;
import app.scalingpolicy.ScalingPolicies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class DecisionEngine{
	@Autowired
	ScalingPolicies scalingPolicies;
	
	@Autowired
	DeploymentEngine deploymentEngine;
	
	@Autowired
	DeploymentRules deploymentRules;
	
	public boolean execute(String serviceId, Map metrics){
		if(scalingPolicies.getPolicy(serviceId).execute(serviceId, metrics)){		
			return deploymentEngine.scaleUp(deploymentRules.getDeploymentRules(serviceId), serviceId);	
		}
		return false;
	}
}