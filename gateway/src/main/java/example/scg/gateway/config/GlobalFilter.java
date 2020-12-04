package example.scg.gateway.config;

import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

/**
 * Created by wansoo.
 * User: accomplishlee
 * Date: 2020/12/02
 * Time: 2:37 오후
 */
@Component
public class GlobalFilter extends AbstractGatewayFilterFactory<GlobalFilter.Config> {
    private static final Logger logger = LogManager.getLogger(GlobalFilter.class);


    public GlobalFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            logger.info("[GlobalFilter baseMessage] " + config.getBaseMessage());
            if(config.isPreLogger()) {
                // exchange : 서비스 요청/응답 값을 담고있는 변수. 요청/응답값을 출력하거나 변환할 때 사용.
                logger.info("[GlobalFilter Start] "+exchange.getRequest());
            }
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                if (config.isPostLogger()) {
                    logger.info("[GlobalFilter End] "+exchange.getResponse());
                }
            }));
        };
    }

    @Getter
    @Setter
    public static class Config {
        //Put the configuration properties for your filter here
        private String baseMessage;
        private boolean preLogger;
        private boolean postLogger;
    }
}
