package com.duing.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilmVO {
    private Long id;
    private String film;
    private String englishName;
    private String director;
    private String Player;
    private Integer length;
    private String synopsis;
    private Integer status;
    private String playTime;
    private String img;
    private String type;
    private String area;
    private String year;
    private Integer wish;
    private BigDecimal score;
    private Integer currentPage;
    private Integer pageSize;
    private String sort;
}
