package app.config;

import app.config.EurekaHealthCheckHandler;
import com.netflix.appinfo.HealthCheckHandler;
import com.netflix.discovery.EurekaClientConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * Created by user on 4/24/17.
 */
//@Configuration
//@EnableConfigurationProperties
//@ConditionalOnClass({EurekaClientConfig.class})
public class SidecarConfig {

//    @Value("${parent.checkpoint.url}")
//    String parentCheckpointUrl;

//    @Primary
//    @Bean
//    public HealthCheckHandler healthCheckHandler() {
//        return new EurekaHealthCheckHandler(parentCheckpointUrl);
//    }


//    @Bean
//    public HealthIndicator healthIndicator() {
//        return new HealthIndicator() {
//            @Override
//            public Health health() {
//                return new Health.Builder().outOfService().build();
//            }
//        };
//    }

}
