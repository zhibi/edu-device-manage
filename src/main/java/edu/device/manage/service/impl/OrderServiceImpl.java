package edu.device.manage.service.impl;

import edu.device.manage.base.base.service.BaseServiceImpl;
import edu.device.manage.base.mybatis.condition.MybatisCondition;
import edu.device.manage.domain.Device;
import edu.device.manage.domain.Order;
import edu.device.manage.mapper.DeviceMapper;
import edu.device.manage.mapper.OrderMapper;
import edu.device.manage.model.OrderModel;
import edu.device.manage.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author 执笔
 * @date 2019/4/9 18:15
 */
@Service
public class OrderServiceImpl extends BaseServiceImpl<OrderMapper, Order> implements OrderService {

    @Autowired
    private OrderMapper  orderMapper;
    @Autowired
    private DeviceMapper deviceMapper;


    @Transactional(rollbackFor = Exception.class)
    @Override
    public void lend(Integer userId, Integer deviceId) {
        Device device = deviceMapper.selectByPrimaryKey(deviceId);
        device.setStatus("借出");
        device.setUpdateTime(new Date());
        deviceMapper.updateByPrimaryKeySelective(device);
        // 生成订单
        Order order = new Order()
                .setDeviceId(deviceId)
                .setUserId(userId)
                .setStatus("借出");
        order.setCreateTime(new Date());
        orderMapper.insertSelective(order);
    }

    @Override
    public List<OrderModel> selectModel(MybatisCondition condition) {
        return orderMapper.selectModel(condition);
    }

    @Override
    public void remand(Integer id) {
        Order order = orderMapper.selectByPrimaryKey(id);
        order.setUpdateTime(new Date());
        order.setStatus("归还");
        orderMapper.updateByPrimaryKeySelective(order);
        Device device = deviceMapper.selectByPrimaryKey(order.getDeviceId());
        device.setStatus("未借");
        device.setUpdateTime(new Date());
        deviceMapper.updateByPrimaryKeySelective(device);
    }

}