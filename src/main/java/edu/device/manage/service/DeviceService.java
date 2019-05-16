package edu.device.manage.service;

import com.github.pagehelper.PageInfo;
import edu.device.manage.base.base.service.BaseService;
import edu.device.manage.base.mybatis.condition.MybatisCondition;
import edu.device.manage.domain.Device;
import edu.device.manage.model.DeviceModel;

/**
 * 
 * @author 执笔
 * @date 2019/4/9 18:30
 */
public interface DeviceService extends BaseService<Device> {

    /**
     * 通过条件分页查找
     * @param example
     * @return
     */
    PageInfo<DeviceModel> selectModelPage(MybatisCondition example);

}