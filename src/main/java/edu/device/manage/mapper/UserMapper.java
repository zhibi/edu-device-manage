package edu.device.manage.mapper;

import edu.device.manage.domain.User;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;


public interface UserMapper extends Mapper<User>{

    /**
     * 统计用户预订情况
     * @param id
     * @return
     */
    List<Map<String, Integer>> count(Integer id);
}
