package com.bibe.crm.entity.dto;

import com.bibe.crm.common.base.BasePage;
import lombok.Data;

@Data
public class FindCustomerDTO  extends BasePage {

    /**
     * 开始时间
     */
    private String startDate;
    /**
     * 结束时间
     */
    private String endDate;

    /**
     * 最后跟进时间
     */
    private String lastDate;

    /**
     * 下次跟进时间
     */
    private String nextDate;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 城市id
     */
    private Integer areaId;

    /**
     * 跟进次数
     */
    private Integer progressNum;

    /**
     * 客户名称
     */
    private String name;

    /**
     * 意向度:0:成交客户,1:A+,2:A-,3:B+,4:B-,5:C+,6:D+,7:E
     */
    private Integer intention;


    /**
     * 客户类别:0代理商 1直客 2采购方
     */
    private Integer type;


    /**
     * 联系人手机号
     */
    private String phone;

}