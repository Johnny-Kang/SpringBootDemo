package com.duing.domain.vo;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVO {
    private String username;
    private String sex;
    private String phone;
    private String email;
    private Integer role;
    private String sign;
    private Integer currentPage;
    private Integer pageSize;
}
