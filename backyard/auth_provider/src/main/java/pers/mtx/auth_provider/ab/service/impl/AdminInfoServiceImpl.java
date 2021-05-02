package pers.mtx.auth_provider.ab.service.impl;

import pers.mtx.auth_provider.ab.entity.AdminInfo;
import pers.mtx.auth_provider.ab.mapper.AdminInfoMapper;
import pers.mtx.auth_provider.ab.service.IAdminInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 管理员信息 服务实现类
 * </p>
 *
 * @author mataoxun
 * @since 2021-04-26
 */
@Service
public class AdminInfoServiceImpl extends ServiceImpl<AdminInfoMapper, AdminInfo> implements IAdminInfoService {

}
