package com.duing.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_evaluate")
public class Evaluate implements Serializable {
    private static final long serialVersionUID = -6905045880881791820L;

    @TableId(type = IdType.AUTO)
    private Integer id;

    private Integer userId;

    private Integer filmId;

    private String content;

    private BigDecimal rate;

    private Integer like;

    private String createTime;
}
