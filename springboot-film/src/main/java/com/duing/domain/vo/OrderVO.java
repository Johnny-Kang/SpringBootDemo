package com.duing.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderVO {
    private Integer id;
    private String orderNumber;
    private String viewDate;
    private String viewTime;
    private Integer count;
    private Integer price;
    private String seat;
    private String createTime;
    private String film;
    private String img;
    private String cinema;
    private String address;
    private String room;
}
