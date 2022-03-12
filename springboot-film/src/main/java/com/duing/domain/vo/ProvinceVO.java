package com.duing.domain.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProvinceVO {
    private Integer value;
    private String label;
    private List<CityVO> children;
}
