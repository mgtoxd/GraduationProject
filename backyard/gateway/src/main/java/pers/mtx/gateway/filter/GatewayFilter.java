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
import pers.mtx.gateway.feign.CheckFeign;
import reactor.core.publisher.Mono;

import java.util.regex.Pattern;


@Component
public class GatewayFilter implements GlobalFilter {

    @Autowired
    CheckFeign feign;
    /**
    * @Author: 马韬循
    * @Description:
    * @DateTime: 15:04 2021/4/25
    * @Params: 
    * @Return 
    **/
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        System.out.println(exchange.getRequest().getURI().getRawPath());
//        String[] PassArray={".*/order/.*"};
//        for (String item :
//                PassArray) {
//            System.out.println(exchange.getRequest().getURI().toString());
//            if (Pattern.matches(item,exchange.getRequest().getURI().toString())){
//                //获取request
//                String token = exchange.getRequest().getHeaders().getFirst("token");
//                if (StringUtils.isEmpty(token)||!checkToken(token)){
//                    ServerHttpResponse response = exchange.getResponse();
//                    response.setStatusCode(HttpStatus.METHOD_FAILURE);
//                    String msg = "token is null or wrong";
//                    DataBuffer buffer = response.bufferFactory().wrap(msg.getBytes());
//                    return response.writeWith(Mono.just(buffer));
//                }
//            }
//        }
        return chain.filter(exchange);
    }

    /**
    * @Author: 马韬循
    * @Description: 验证token
    * @DateTime: 15:04 2021/4/25
    * @Params: token
    * @Return boolean
    **/
    public boolean checkToken( String token){
        switch (token.toCharArray()[token.length()]){
            case 'c':
                if (feign.whetherConsumer(token)) return true;
            case 'a':
                if (feign.whetherConsumer(token)) return true;
        }
        return false;
    }
}
