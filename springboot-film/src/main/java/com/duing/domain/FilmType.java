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
@TableName("t_film_type")
public class FilmType implements Serializable {
    private static final long serialVersionUID = 8941546399574894792L;
    @TableId(type = IdType.AUTO)
    private Long id;
    private String type;
    @TableField("is_deleted")
    private Integer deleted;
}
