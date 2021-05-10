package pers.mtx.order_pro.ab.service.impl;

import pers.mtx.order_pro.ab.entity.OrderState;
import pers.mtx.order_pro.ab.mapper.OrderStateMapper;
import pers.mtx.order_pro.ab.service.IOrderStateService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单状态表 服务实现类
 * </p>
 *
 * @author mataoxun
 * @since 2021-05-05
 */
@Service
public class OrderStateServiceImpl extends ServiceImpl<OrderStateMapper, OrderState> implements IOrderStateService {

}
