package app;

import app.config.EurekaHealthCheckHandler;
import com.netflix.discovery.EurekaClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.sidecar.EnableSidecar;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableSidecar
public class SidecarApplication {

    public static void main(String[] args) {
        final ApplicationContext context = SpringApplication.run(SidecarApplication.class, args);
        final EurekaClient eurekaClient = context.getBean(EurekaClient.class);
        eurekaClient.registerHealthCheck(new EurekaHealthCheckHandler());
    }

}

