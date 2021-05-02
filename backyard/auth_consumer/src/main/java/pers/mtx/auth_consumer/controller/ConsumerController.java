package pers.mtx.auth_consumer.controller;

import com.github.dozermapper.core.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;
import pers.mtx.auth_consumer.entity.*;
import pers.mtx.auth_consumer.feign.ConsumerAuthFeign;
import pers.mtx.auth_consumer.feign.ConsumerFeign;
import pers.mtx.auth_consumer.feign.proFeign;
import pers.mtx.auth_consumer.result.RestResponse;
import pers.mtx.auth_consumer.vo.AdminInfoVo;
import pers.mtx.auth_consumer.vo.AdminUpdateVo;
import pers.mtx.auth_consumer.vo.ConsumerInfoVo;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: 马韬循
 * @Description:
 * @DateTime: 2021/4/26 10:56
 **/
@RestController
@RequestMapping("/consumer")
public class ConsumerController {
    @Autowired
    proFeign profeign;
    @Autowired
    Mapper dozerMapper;
    @Autowired
    ConsumerFeign consumerFeign;
    @Autowired
    ConsumerAuthFeign consumerAuthFeign;

    @GetMapping("/page")
    public RestResponse getConsumerInfoPage(@RequestParam("count") Integer count, @RequestParam("size") Integer size){
        List<ConsumerAuth> consumerAuths = profeign.pageConsumerAuth(count, size);
        ArrayList<ConsumerInfoVo> consumerInfoVos = new ArrayList<>();
        for (ConsumerAuth auth :
                consumerAuths) {
            ConsumerInfoVo consumerInfoVo = new ConsumerInfoVo();
            ConsumerInfo consumerInfo = profeign.getConsumerInfoByid(auth.getConId());
            ConsumerBaseInfo consumerBaseInfo = profeign.getConsumerBaseInfoByid(auth.getConId());
            dozerMapper.map(consumerInfo,consumerInfoVo);
            consumerInfoVo.setConId(auth.getConId()).setDate(auth.getModifyDate()).setConEmail(auth.getConEmail()).setConPhoneNum(auth.getConPhoneNum()).setConName(consumerBaseInfo.getConName());
            consumerInfoVos.add(consumerInfoVo);
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("pageNum",consumerFeign.count()/size);
        map.put("list",consumerInfoVos);
        return RestResponse.success(map);
    }

    @GetMapping("/removeByid")
    public RestResponse removeByid(@RequestParam("id") String id){
        if (consumerAuthFeign.removeById(id)){
            return RestResponse.success();
        }
        else return RestResponse.error(250,"删除失败");
    }
}
