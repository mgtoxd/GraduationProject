package pers.mtx.order_pro.ab.service.impl;

import pers.mtx.order_pro.ab.entity.OrderInfo;
import pers.mtx.order_pro.ab.mapper.OrderInfoMapper;
import pers.mtx.order_pro.ab.service.IOrderInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单基本信息 服务实现类
 * </p>
 *
 * @author mataoxun
 * @since 2021-05-05
 */
@Service
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfo> implements IOrderInfoService {

}
