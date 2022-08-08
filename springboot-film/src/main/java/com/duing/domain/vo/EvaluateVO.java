package com.duing.domain.vo;

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
public class EvaluateVO{

    private Integer id;

    private Integer userId;

    private Integer filmId;

    private String content;

    private BigDecimal rate;

    private Integer like;

    private String createTime;

    private String img;

    private String userName;
}
