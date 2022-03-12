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
@TableName("province")
public class Province implements Serializable {
    private static final long serialVersionUID = 4304770123373856956L;
    @TableId(type = IdType.AUTO)
    private String code;
    private String name;
}
