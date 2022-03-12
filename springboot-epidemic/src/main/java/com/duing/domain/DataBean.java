package com.duing.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("china_data")
public class DataBean implements Serializable {
    private static final long serialVersionUID = -5019299178941860888L;
    private Integer id;
    private String area;
    private Integer nowConfirm;
    private Integer confirm;
    private Integer heal;
    private Integer dead;
}
