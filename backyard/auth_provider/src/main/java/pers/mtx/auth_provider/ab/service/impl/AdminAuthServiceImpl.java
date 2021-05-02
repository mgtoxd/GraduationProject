package pers.mtx.auth_provider.ab.service.impl;

import pers.mtx.auth_provider.ab.entity.AdminAuth;
import pers.mtx.auth_provider.ab.mapper.AdminAuthMapper;
import pers.mtx.auth_provider.ab.service.IAdminAuthService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 管理员认证 服务实现类
 * </p>
 *
 * @author mataoxun
 * @since 2021-04-26
 */
@Service
public class AdminAuthServiceImpl extends ServiceImpl<AdminAuthMapper, AdminAuth> implements IAdminAuthService {

}
