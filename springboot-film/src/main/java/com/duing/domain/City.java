package com.duing.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("city")
public class City implements Serializable {
    private static final long serialVersionUID = 1595957008849677233L;
    @TableId(type = IdType.AUTO)
    private String code;
    private String name;
    private String provinceCode;
}
