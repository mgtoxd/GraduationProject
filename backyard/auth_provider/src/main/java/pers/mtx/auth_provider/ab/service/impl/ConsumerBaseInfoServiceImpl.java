package pers.mtx.auth_provider.ab.service.impl;

import pers.mtx.auth_provider.ab.entity.ConsumerBaseInfo;
import pers.mtx.auth_provider.ab.mapper.ConsumerBaseInfoMapper;
import pers.mtx.auth_provider.ab.service.IConsumerBaseInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 消费者常用信息表 服务实现类
 * </p>
 *
 * @author mataoxun
 * @since 2021-04-26
 */
@Service
public class ConsumerBaseInfoServiceImpl extends ServiceImpl<ConsumerBaseInfoMapper, ConsumerBaseInfo> implements IConsumerBaseInfoService {

}
