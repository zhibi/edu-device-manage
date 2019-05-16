package edu.device.manage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import edu.device.manage.base.base.service.BaseServiceImpl;
import edu.device.manage.base.mybatis.condition.MybatisCondition;
import edu.device.manage.domain.Order;
import edu.device.manage.mapper.OrderMapper;
import edu.device.manage.domain.Coupon;
import edu.device.manage.mapper.CouponMapper;
import edu.device.manage.model.OrderModel;
import edu.device.manage.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.Date;
import java.util.List;

/**
 * @author 执笔
 * @date 2019/4/9 18:15
 */
@Service
public class OrderServiceImpl extends BaseServiceImpl<OrderMapper, Order> implements OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private CouponMapper couponMapper;

    @Transient
    @Override
    public void pay(Order order) {
        List<Coupon> coupons = couponMapper.selectByExample(new MybatisCondition().eq("user_id", order.getUserId()).eq("status", "待使用"));
        if (coupons.size() > 0) {
            Coupon coupon = coupons.get(0);
            coupon.setStatus("已使用");
            couponMapper.updateByPrimaryKeySelective(coupon);
            order.setCouponId(coupon.getId());
        }
        order.setPayTime(new Date());
        order.setStatus("已支付");
        orderMapper.updateByPrimaryKeySelective(order);
    }

    @Override
    public List<OrderModel> selectModel(MybatisCondition condition) {
        return orderMapper.selectModel(condition);
    }

    @Override
    public PageInfo<OrderModel> selectModelPage(MybatisCondition condition) {
        PageHelper.startPage(condition.getPageNum(), condition.getPageSize());
        return new PageInfo<>(selectModel(condition));
    }

    @Override
    public OrderModel selectModelById(Long id) {
        MybatisCondition example = new MybatisCondition()
                .eq("o.id", id);
        List<OrderModel> list = selectModel(example);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
}