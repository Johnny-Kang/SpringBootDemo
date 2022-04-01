package com.duing.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_cinema")
public class Cinema implements Serializable {
    private static final long serialVersionUID = 2546747863792635103L;
    @TableId(type = IdType.AUTO)
    private Long id;
    private String cinema;
    private String address;
    private Integer brandId;
    private String areaId;
    @TableField("is_rebook")
    private Integer rebook;
    @TableField("is_refund")
    private Integer refund;
    private String createTime;
    @TableField("is_deleted")
    private Integer deleted;
}
