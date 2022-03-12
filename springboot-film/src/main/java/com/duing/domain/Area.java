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
@TableName("area")
public class Area implements Serializable {
    private static final long serialVersionUID = -3871634095380633338L;
    @TableId(type = IdType.AUTO)
    private String code;
    private String name;
    private String cityCode;
    private String provinceCode;
}
