package com.bibe.crm.entity.vo;

import lombok.Data;

import java.util.List;

@Data
public class DeptInputVO {

    private Integer id;

    private Integer pid;

    private String  title;

    private List<IdNameVO> children;
}
