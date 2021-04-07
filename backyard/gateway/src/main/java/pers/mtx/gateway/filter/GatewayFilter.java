package pers.mtx.gateway.filter;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import pers.mtx.gateway.feign.tstFeign;
import reactor.core.publisher.Mono;

import java.util.regex.Pattern;


@Component
public class GatewayFilter implements GlobalFilter {
    @Autowired
    tstFeign feign;
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        System.out.println(exchange.getRequest().getURI().getRawPath());
//        String[] PassArray={".*/auth/.*"};
//        for (String item :
//                PassArray) {
//            if (Pattern.matches(item,exchange.getRequest().getURI().getRawPath())){
//                return chain.filter(exchange);
//            }
//        }
//
//
//        //获取request
//        String token = exchange.getRequest().getHeaders().getFirst("token");
//        if (StringUtils.isEmpty(token)){
//            ServerHttpResponse response = exchange.getResponse();
//            response.setStatusCode(HttpStatus.BAD_GATEWAY);
//            String msg = "token is null";
//            DataBuffer buffer = response.bufferFactory().wrap(msg.getBytes());
//            return response.writeWith(Mono.just(buffer));
//        }else {
//            String tst = feign.tst();
//            ServerHttpResponse response = exchange.getResponse();
//            DataBuffer buffer = response.bufferFactory().wrap(tst.getBytes());
//            return response.writeWith(Mono.just(buffer));
//        }
//        //放行执行转发接口
        return chain.filter(exchange);
    }
}
