package app.config;

import com.netflix.appinfo.HealthCheckHandler;
import com.netflix.appinfo.InstanceInfo.InstanceStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


public class EurekaHealthCheckHandler implements HealthCheckHandler {

    private RestTemplate restTemplate;

    private String parentCheckpointUrl;

    public EurekaHealthCheckHandler() {
        this.parentCheckpointUrl = "http://localhost:10102/";
        this.restTemplate = new RestTemplate();
    }

    public Boolean checkStatus() {
        try {
            ResponseEntity<String> response = restTemplate.getForEntity(parentCheckpointUrl, String.class);
            if (response.getStatusCode().is2xxSuccessful()) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    @Override
    public InstanceStatus getStatus(InstanceStatus instanceStatus) {
        if (checkStatus()) {
            return InstanceStatus.UP;
        }
        return InstanceStatus.DOWN;
    }
}