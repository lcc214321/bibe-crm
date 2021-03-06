package com.bibe.crm.api;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bibe.crm.dao.UserMapper;
import com.bibe.crm.entity.dto.CountDTO;
import com.bibe.crm.entity.dto.CustomerDTO;
import com.bibe.crm.entity.dto.CustomerMoveDTO;
import com.bibe.crm.entity.dto.FindCustomerDTO;
import com.bibe.crm.entity.vo.RespVO;
import com.bibe.crm.service.CustomerProgressService;
import com.bibe.crm.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/customer")
public class CustomerController {


    @Resource
    private CustomerService customerService;

    @Resource
    private CustomerProgressService  customerProgressService;

    @Resource
    private UserMapper userMapper;


    /**
     * 按时间统计客户
     * @param countDTO
     * @return
     */
    @PostMapping("/findCountByDate")
    public RespVO findCountByDate(@RequestBody CountDTO countDTO){
        if (countDTO.getDeptId()!=null){
            countDTO.setUserIds(userMapper.findIdByDeptId(countDTO.getDeptId()));
        }
        return customerService.findCountByDate(countDTO);
    }

    /**
     * 按分类统计客户
     * @param countDTO
     * @return
     */
    @PostMapping("/findCountBySort")
    public RespVO findCountBySort(@RequestBody CountDTO countDTO){
        if (countDTO.getDeptId()!=null){
            countDTO.setUserIds(userMapper.findIdByDeptId(countDTO.getDeptId()));
        }
        return customerService.findCountBySort(countDTO);
    }


    /**
     * 修改自己
     * @param dto
     * @return
     */
    @PutMapping("/update")
    public RespVO update(@RequestBody CustomerDTO dto){
        return customerService.update(dto);
    }


    /**
     * 修改别人
     * @param dto
     * @return
     */
    @PutMapping("/updateHe")
    public RespVO updateHe(@RequestBody CustomerDTO dto){
        return customerService.update(dto);
    }

    /**
     * 添加
     * @param customerDTO
     * @return
     */
    @PostMapping("/add")
    public RespVO add(@RequestBody CustomerDTO customerDTO){
        return customerService.add(customerDTO);
    }


    /**
     * 编辑
     * @param id
     * @return
     */
    @GetMapping("/edit")
    public RespVO edit(Integer id){
        return customerService.edit(id);
    }


    /**
     * 分页列表
     * @param dto
     * @return
     */
    @PostMapping("/pageList")
    public RespVO pageList(@RequestBody FindCustomerDTO dto){
        Page page = dto.getPage();
        return RespVO.ofSuccess(customerService.pageList(dto,page));
    }


    /**
     * 我的客戶分页列表
     * @param dto
     * @return
     */
    @PostMapping("/myPageList")
    public RespVO myPageList(@RequestBody FindCustomerDTO dto){
        Page page = dto.getPage();
        return RespVO.ofSuccess(customerService.myPageList(dto,page));
    }


    /**
     * 联系跟进列表
     * @param customerId
     * @return
     */
    @GetMapping("/progressList")
    public RespVO progressList(Integer customerId){
        return customerProgressService.list(customerId);
    }

    /**
     * 删除自己
     * @param ids
     * @return
     */
    @DeleteMapping("/delete")
    public RespVO delete(Integer[] ids){
         customerService.delete(ids);
         return RespVO.ofSuccess();
    }

    /**
     * 删除他人
     * @param ids
     * @return
     */
    @DeleteMapping("/deleteHe")
    public RespVO deleteHe(Integer[] ids){
         customerService.delete(ids);
         return RespVO.ofSuccess();
    }


    /**
     * 转交自己客户(其他成员)
     * @return
     */
    @PutMapping("/move")
    public RespVO move(@RequestBody CustomerMoveDTO dto){
       return customerService.move(dto.getUserId(),null,dto.getIds());
    }

    /**
     * 转交他人客户(其他成员)
     * @return
     */
    @PutMapping("/moveHe")
    public RespVO moveHe(@RequestBody CustomerMoveDTO dto){
        return customerService.move(dto.getUserId(),null,dto.getIds());
    }


    /**
     * 转交他人客户(公共客户)
     * @param dto
     * @return
     */
    @PutMapping("/movePublicHe")
    public RespVO movePublicHe(@RequestBody CustomerMoveDTO dto){
        return customerService.move(null,dto.getGroupId(),dto.getIds());
    }

    /**
     * 转交自己客户(公共客户)
     * @param dto
     * @return
     */
    @PutMapping("/movePublic")
    public RespVO movePublic(@RequestBody CustomerMoveDTO dto){
        return customerService.move(null,dto.getGroupId(),dto.getIds());
    }


    /**
     * 模糊查询客户名称
     * @param name
     * @return
     */
    @GetMapping("/findLikeName")
    public RespVO findLikeName(String name){
        return customerService.findLikeName(name);
    }
}
