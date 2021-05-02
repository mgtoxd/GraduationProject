package pers.mtx.auth_provider.ab.service.impl;

import pers.mtx.auth_provider.ab.entity.ConsumerAuth;
import pers.mtx.auth_provider.ab.mapper.ConsumerAuthMapper;
import pers.mtx.auth_provider.ab.service.IConsumerAuthService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 消费者认证表 服务实现类
 * </p>
 *
 * @author mataoxun
 * @since 2021-04-26
 */
@Service
public class ConsumerAuthServiceImpl extends ServiceImpl<ConsumerAuthMapper, ConsumerAuth> implements IConsumerAuthService {

}
