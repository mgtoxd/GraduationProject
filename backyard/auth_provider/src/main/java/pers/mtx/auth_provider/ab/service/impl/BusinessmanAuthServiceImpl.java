package pers.mtx.auth_provider.ab.service.impl;

import pers.mtx.auth_provider.ab.entity.BusinessmanAuth;
import pers.mtx.auth_provider.ab.mapper.BusinessmanAuthMapper;
import pers.mtx.auth_provider.ab.service.IBusinessmanAuthService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商铺管理者认证 服务实现类
 * </p>
 *
 * @author mataoxun
 * @since 2021-04-05
 */
@Service
public class BusinessmanAuthServiceImpl extends ServiceImpl<BusinessmanAuthMapper, BusinessmanAuth> implements IBusinessmanAuthService {

}
