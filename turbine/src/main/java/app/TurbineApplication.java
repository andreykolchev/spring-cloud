package app;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableTurbineStream
@EnableEurekaClient
public class TurbineApplication {

	@Value("${app.rabbitmq.host}")
	String rabbitMQHost;

	@Bean
	public ConnectionFactory connectionFactory() {
		CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory(rabbitMQHost);
		return cachingConnectionFactory;
	}

	public static void main(String[] args) {
		SpringApplication.run(TurbineApplication.class, args);
	}

}


