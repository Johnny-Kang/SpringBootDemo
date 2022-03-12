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
@TableName("t_user")
public class User implements Serializable {
    private static final long serialVersionUID = -7704297048422007185L;
    @TableId(type = IdType.AUTO)
    private Long id;
    private String username;
    private String password;
    private String sex;
    private String phone;
    private String email;
    private String imgUrl;
    private String createTime;
    private String updateTime;
    private Integer role;
    @TableField("is_deleted")
    private Integer deleted;
}
