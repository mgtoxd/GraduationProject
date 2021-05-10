package pers.mtx.auth_provider.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.mtx.auth_provider.util.RedisUtil;

/**
 * @Author: 马韬循
 * @Description:
 * @DateTime: 2021/4/7 21:25
 **/
@Service
public class tokenService {
    @Autowired
    RedisUtil redisUtil;
    /**
    * @Author: 马韬循
    * @Description: 检查token是否存在
    * @DateTime: 21:27 2021/4/7
    * @Params: String token
    * @Return boolean
    **/
    public boolean checkToken(String token){
        if (redisUtil.hasKey(token)) {
            redisUtil.expire(token,3600);
            return true;
        }
        return false;
    }

    public boolean checkAdminToken(String token){
        if (redisUtil.hasKey(token)) {
            redisUtil.expire(token,7200);
            return true;
        }
        return false;
    }


}
