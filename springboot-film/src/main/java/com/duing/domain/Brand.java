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
@TableName("t_brand")
public class Brand implements Serializable {
    private static final long serialVersionUID = 984088792154681788L;
    @TableId(type = IdType.AUTO)
    private Long id;
    private String brand;
    @TableField("is_deleted")
    private Integer deleted;
}
