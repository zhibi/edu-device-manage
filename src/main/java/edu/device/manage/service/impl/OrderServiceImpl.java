package edu.device.manage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import edu.device.manage.base.base.service.BaseServiceImpl;
import edu.device.manage.base.mybatis.condition.MybatisCondition;
import edu.device.manage.domain.Order;
import edu.device.manage.mapper.OrderMapper;
import edu.device.manage.model.OrderModel;
import edu.device.manage.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.List;

/**
 * @author 执笔
 * @date 2019/4/9 18:15
 */
@Service
public class OrderServiceImpl extends BaseServiceImpl<OrderMapper, Order> implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Transient
    @Override
    public void pay(Order order) {
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