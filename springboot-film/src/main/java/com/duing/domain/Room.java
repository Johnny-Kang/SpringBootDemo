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
@TableName("t_room")
public class Room implements Serializable {
    private static final long serialVersionUID = 8759876026409612244L;
    @TableId(type = IdType.AUTO)
    private Long id;
    private String room;
    private Integer row;
    private Integer column;
    private Integer roomTypeId;
    @TableField("is_deleted")
    private Integer deleted;
}
