package pers.mtx.auth_provider.ab.service.impl;

import pers.mtx.auth_provider.ab.entity.ConsumerInfo;
import pers.mtx.auth_provider.ab.mapper.ConsumerInfoMapper;
import pers.mtx.auth_provider.ab.service.IConsumerInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 消费者详细信息表 服务实现类
 * </p>
 *
 * @author mataoxun
 * @since 2021-04-26
 */
@Service
public class ConsumerInfoServiceImpl extends ServiceImpl<ConsumerInfoMapper, ConsumerInfo> implements IConsumerInfoService {

}
