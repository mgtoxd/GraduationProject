package pers.mtx.order_pro.ab.service.impl;

import pers.mtx.order_pro.ab.entity.OrderMemberInfo;
import pers.mtx.order_pro.ab.mapper.OrderMemberInfoMapper;
import pers.mtx.order_pro.ab.service.IOrderMemberInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单旅行者关联表  服务实现类
 * </p>
 *
 * @author mataoxun
 * @since 2021-05-05
 */
@Service
public class OrderMemberInfoServiceImpl extends ServiceImpl<OrderMemberInfoMapper, OrderMemberInfo> implements IOrderMemberInfoService {

}
