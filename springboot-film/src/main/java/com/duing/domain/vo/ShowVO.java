package com.duing.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShowVO {
    private long id;
    private String viewDate;
    private String viewTime;
    private Integer filmId;
    private Integer cinemaId;
    private Integer price;
    private Integer roomId;
    private String room;
}
