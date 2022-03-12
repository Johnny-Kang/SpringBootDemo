package com.duing.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
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
@TableName("t_film")
public class Film implements Serializable {
    private static final long serialVersionUID = 2231516283576409495L;

    @TableId(type = IdType.AUTO)
    private Long id;
    private String film;
    private String englishName;
    private String director;
    private String Player;
    private Integer length;
    private String synopsis;
    private Integer status;
    private String playTime;
    private String imgPath;
    private String typeId;
    private Integer areaId;
    private Integer yearId;
    private Integer wish;
    private BigDecimal score;
    @TableField("is_deleted")
    private Integer deleted;
}
