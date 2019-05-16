package edu.device.manage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import edu.device.manage.base.base.service.BaseServiceImpl;
import edu.device.manage.base.mybatis.condition.MybatisCondition;
import edu.device.manage.domain.Device;
import edu.device.manage.mapper.DeviceMapper;
import edu.device.manage.model.DeviceModel;
import edu.device.manage.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DeviceServiceImpl extends BaseServiceImpl<DeviceMapper, Device> implements DeviceService {

    @Autowired
    private DeviceMapper deviceMapper;

    @Override
    public PageInfo<DeviceModel> selectModelPage(MybatisCondition example) {
        PageHelper.startPage(example.getPageNum(), example.getPageSize());
        return new PageInfo<>(deviceMapper.selectModel(example));
    }

}