package example.scg.gateway.config;

import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

/**
 * Created by wansoo.
 * User: accomplishlee
 * Date: 2020/12/02
 * Time: 2:54 오후
 */

//AbstractGatewayFilterFactory: GatewayFilter 구현을 위한 추상클래스이다.
@Component
public class UserSvcFilter extends AbstractGatewayFilterFactory<UserSvcFilter.Config> {
    private static final Logger logger = LogManager.getLogger(UserSvcFilter.class);
    public UserSvcFilter() {
        super(UserSvcFilter.Config.class);
    }

    @Override
    public GatewayFilter apply(UserSvcFilter.Config config) {
        // exchange : 서비스 요청/응답 값을 담고있는 변수. 요청/응답값을 출력하거나 변환할 때 사용.
        return (exchange, chain) -> {

            //여기서 요청 처리
            logger.info("[UserSvcFilter baseMessage] " + config.getBaseMessage());
            if(config.isPreLogger()) {
                // exchange : 서비스 요청/응답 값을 담고있는 변수. 요청/응답값을 출력하거나 변환할 때 사용.
                logger.info("[UserSvcFilter Start] "+exchange.getRequest().toString());
            }
            // 만약 Token 검증 로직이 필요하다면?
//            try {
//                String token = exchange.getRequest().getHeaders().get("Authorization").get(0).substring(7);
//                logger.info("token :" + token);
//            } catch (NullPointerException e) {
//                logger.warn("no token.");
//                exchange.getResponse().setStatusCode(HttpStatus.valueOf(401));
//                logger.info("status code :" + exchange.getResponse().getStatusCode());
//                return Mono.empty();
//            }

            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                //여기서 응답 처리
                if (config.isPostLogger()) {
                    logger.info("[UserSvcFilter End] "+exchange.getResponse().toString());
                }
            }));
        };
    }

    // Filter에 설정한 속성 값을 위한 값 클래스
    @Getter
    @Setter
    public static class Config {
        private String baseMessage;
        private boolean preLogger;
        private boolean postLogger;
    }
}
