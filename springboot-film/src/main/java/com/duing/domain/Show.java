package com.duing.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.PrintStream;
import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_show")
public class Show implements Serializable {
    private static final long serialVersionUID = 2607929886133116566L;
    @TableId(type = IdType.AUTO)
    private Long id;
    private String viewDate;
    private String viewTime;
    private Integer filmId;
    private Integer cinemaId;
    private Integer price;
    private Integer roomId;
    @TableField("is_deleted")
    private Integer deleted;
}
