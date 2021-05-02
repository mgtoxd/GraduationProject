package pers.mtx.auth_provider.ab.service.impl;

import pers.mtx.auth_provider.ab.entity.ConsumerLevel;
import pers.mtx.auth_provider.ab.mapper.ConsumerLevelMapper;
import pers.mtx.auth_provider.ab.service.IConsumerLevelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 消费者与等级绑定表 服务实现类
 * </p>
 *
 * @author mataoxun
 * @since 2021-04-26
 */
@Service
public class ConsumerLevelServiceImpl extends ServiceImpl<ConsumerLevelMapper, ConsumerLevel> implements IConsumerLevelService {

}
