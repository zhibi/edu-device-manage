package edu.device.manage.base.base.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;

/**
 * 分页 基础信息
 *
 * @author 执笔
 */
@Getter
@Setter
public abstract class BasePageDTO {
    @Transient
    private Integer pageNum  = 0;
    @Transient
    private Integer pageSize = 10;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date    createTime;
    private Date    updateTime;
}
