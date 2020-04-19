package com.lizhenfang.lizhenfangday01.entity;

import lombok.Data;

@Data
public class UserVo extends  User{

    private String nameZhs;
    private String rids;

    private String provinceName;
    private String cityName;
    private String districtName;
}
