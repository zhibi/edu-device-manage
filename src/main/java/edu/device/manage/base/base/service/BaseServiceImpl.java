package edu.device.manage.base.base.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import edu.device.manage.base.base.dto.BasePageDTO;
import edu.device.manage.base.mybatis.condition.MybatisCondition;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;

import java.util.Date;
import java.util.List;

/**
 * 基础service 实现
 *
 * @param <T>
 * @author 执笔
 */
public class BaseServiceImpl<E extends Mapper<T>, T extends BasePageDTO> implements BaseService<T> {

    @Autowired
    protected E mapper;


    @Override
    public PageInfo<T> selectPage(T dto) {
        PageHelper.orderBy("id desc");
        startPage(dto);
        return new PageInfo<>(mapper.select(dto));
    }

    @Override
    public PageInfo<T> selectPage(MybatisCondition condition) {
        startPage(condition);
        return new PageInfo<>(mapper.selectByExample(condition));
    }

    @Override
    public int merge(T dto) {
        if (dto.getId() == null) {
            return mapper.insertSelective(dto);
        } else {
            return mapper.updateByPrimaryKeySelective(dto);
        }
    }

    @Override
    public boolean isExist(MybatisCondition condition) {
        int count = mapper.selectCountByExample(condition);
        return count != 0;
    }

    @Override
    public T selectByPrimaryKey(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<T> select(T obj) {
        PageHelper.orderBy("id desc");
        return mapper.select(obj);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer selectCount(T t) {
        return mapper.selectCount(t);
    }

    @Override
    public int updateByPrimaryKeySelective(T t) {
        t.setUpdateTime(new Date());
        return mapper.updateByPrimaryKeySelective(t);
    }

    @Override
    public List<T> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public int insertSelective(T t) {
        t.setCreateTime(new Date());
        return mapper.insertSelective(t);
    }


    /**
     * 开始分页
     *
     * @param dto
     */
    protected void startPage(BasePageDTO dto) {
        PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
    }
}
