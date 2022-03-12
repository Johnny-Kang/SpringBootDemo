package com.duing.domain.vo;

import lombok.Data;

@Data
public class CinemaVO {
    private String cinema;
    private String brand;
    private String city;
    private String area;
    private String address;
    private Integer isRefund;
    private Integer isRebook;
    private String createTime;
    private Integer currentPage;
    private Integer pageSize;
}
