package edu.device.manage.mapper;

import edu.device.manage.base.mybatis.condition.MybatisCondition;
import edu.device.manage.domain.Device;
import edu.device.manage.model.DeviceModel;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Created by 执笔 on generate.
 */
public interface DeviceMapper extends Mapper<Device> {

    List<DeviceModel> selectModel(MybatisCondition example);
}
