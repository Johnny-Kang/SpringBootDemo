package com.duing.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
@TableName("graph")
public class Graph implements Serializable {

    private static final long serialVersionUID = 6073805514969373158L;

    @TableId
    private Integer id;
    private String date;
    private Integer confirm;
    private Integer suspect;
}
