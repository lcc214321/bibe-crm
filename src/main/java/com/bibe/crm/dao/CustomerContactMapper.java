package com.bibe.crm.dao;
import java.util.Collection;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

import com.bibe.crm.entity.po.CustomerContact;

public interface CustomerContactMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CustomerContact record);

    int insertSelective(CustomerContact record);

    CustomerContact selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CustomerContact record);

    int updateByPrimaryKey(CustomerContact record);

    int insertList(@Param("list")List<CustomerContact> list);

    int updateByCustomerIdin(@Param("updated")CustomerContact updated,@Param("customerIdCollection")Collection<Integer> customerIdCollection);

    CustomerContact findAllById(@Param("id")Integer id);

    String findAllByCustomerId(@Param("customerId")Integer cId);

    List<CustomerContact> list(@Param("customerId")Integer cId);

    Map<String,Object> show(Integer id);

    IPage<Map<String,Object>> pageList(@Param("customerId")Integer cId, Page page);


    CustomerContact checkCustomerType(@Param("customerId")Integer customerId,@Param("id")Integer id);

    Integer checkByPhone(@Param("phone")String phone);

    int updateTypeByCustomerId(@Param("customerId")Integer customerId);

    int deleteByCustomerIdIn(@Param("customerIdCollection")Integer[]  customerIdCollection);
}