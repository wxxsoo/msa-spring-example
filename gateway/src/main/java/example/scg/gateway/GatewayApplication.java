package example.scg.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class GatewayApplication {

	public static void main(String[] args) {
		//Reactor Netty 액세스 로그를 활성화
		//공식 문서에 따르면 Spring Boot 설정이 아니기 때문에 yml으로 설정 불가
		System.setProperty("reactor.netty.http.server.accessLogEnabled", "true");
		SpringApplication.run(GatewayApplication.class, args);
	}

}
