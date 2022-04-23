package com.duing.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShowInfoVo {
    private long id;
    private String viewDate;
    private String viewTime;
    private Integer filmId;
    private String film;
    private String imgPath;
    private Integer length;
    private Integer cinemaId;
    private String cinema;
    private Integer price;
    private Integer roomId;
    private String room;
    private String area;
    private Integer rowNum;
    private Integer columnNum;
    private Integer currentPage;
    private Integer pageSize;
}
