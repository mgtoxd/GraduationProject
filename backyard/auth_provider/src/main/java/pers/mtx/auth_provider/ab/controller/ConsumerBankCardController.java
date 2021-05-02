package pers.mtx.auth_provider.ab.controller;

import lombok.Data;
import pers.mtx.auth_provider.ab.entity.ConsumerBankCard;
import pers.mtx.auth_provider.ab.service.IConsumerBankCardService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

    import org.springframework.web.bind.annotation.RestController;

/**
* <p>
    * 消费者银行卡信息 前端控制器
    * </p>
*
* @author mataoxun
* @since 2021-04-26
*/
    @RestController
@RequestMapping("/consumer-bank-card")
    public class ConsumerBankCardController {
@Autowired
private IConsumerBankCardService iConsumerBankCardService;

@PostMapping(value = "/add")
public  Boolean add(@RequestBody ConsumerBankCard param) {
return iConsumerBankCardService.save(param);
}
@PostMapping(value = "/addList")
public  Boolean addList(@RequestBody List<ConsumerBankCard> param) {
return iConsumerBankCardService.saveBatch(param);
}
@PostMapping(value = "/addOrUpdate")
public  Boolean addOrUpdate(@RequestBody ConsumerBankCard param) {
return iConsumerBankCardService.saveOrUpdate(param);
}
@PostMapping(value = "/addOrUpdateList")
public  Boolean addOrUpdateList(@RequestBody List<ConsumerBankCard> param) {
return iConsumerBankCardService.saveOrUpdateBatch(param);
}
@GetMapping(value = "/removeById")
public  Boolean removeById(@RequestParam("id") String id) {
return iConsumerBankCardService.removeById(id);
}
@PostMapping(value = "/removeByIdList")
public  Boolean removeByIdList(@RequestBody List<String> ids) {
    return iConsumerBankCardService.removeByIds(ids);
    }
    @PostMapping(value = "/updateById")
    public  Boolean updateById(@RequestBody ConsumerBankCard param) {
    return iConsumerBankCardService.updateById(param);
    }
    @PostMapping(value = "/updateListById")
    public  Boolean updateBatchById(@RequestBody List<ConsumerBankCard> param) {
    return iConsumerBankCardService.updateBatchById(param);
    }
    @PostMapping(value = "/listByIdList")
    public  List<ConsumerBankCard> listByIdList(@RequestBody List<String> param) {
        return iConsumerBankCardService.listByIds(param);
        }

        @GetMapping(value = "/getByid")
        public  ConsumerBankCard getByid(@RequestParam("id") String id) {
        return iConsumerBankCardService.getById(id);
        }
        @GetMapping(value = "/pageByModify")
        public List<ConsumerBankCard> page(@RequestParam("count") Integer count,@RequestParam("size") Integer size) {
        Page<ConsumerBankCard> stuPage = new Page<>(count,size);
        QueryWrapper<ConsumerBankCard> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("modify_date");
        return iConsumerBankCardService.page(stuPage,wrapper).getRecords();
        }


        }
