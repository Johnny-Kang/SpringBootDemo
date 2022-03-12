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
@TableName("t_order")
public class Order implements Serializable {
    private static final long serialVersionUID = 6234444942132915779L;
    @TableId(type = IdType.AUTO)
    private Long id;
    private Integer showId;
    private Integer userId;
    private Integer count;
    private Integer price;
    private String seat;
}
