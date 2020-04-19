package com.lizhenfang.lizhenfangday01.entity;

import lombok.Data;

import java.util.List;
@Data
public class NationVo {
    private Integer id;
    private  String name;
    private List<Nation> list;
}
