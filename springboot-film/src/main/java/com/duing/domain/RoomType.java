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
@TableName("t_room_type")
public class RoomType implements Serializable {
    private static final long serialVersionUID = 4169279033785057708L;
    @TableId(type = IdType.AUTO)
    private Long id;
    private String type;
    @TableField("is_deleted")
    private Integer deleted;
}
