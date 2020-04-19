package com.lizhenfang.lizhenfangday01.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lizhenfang.lizhenfangday01.Vo.ResultEntity;
import com.lizhenfang.lizhenfangday01.entity.Role;
import com.lizhenfang.lizhenfangday01.entity.RoleVo;
import com.lizhenfang.lizhenfangday01.entity.UserVo;
import com.lizhenfang.lizhenfangday01.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * InnoDB free: 37888 kB 前端控制器
 * </p>
 *
 * @author @李振芳
 * @since 2020-03-30
 */
@RestController
@RequestMapping("/role")
public class RoleController {
  @Autowired
    private IRoleService iRoleService;

  @RequestMapping("/findAll")
  public ResultEntity findAll(){
      return ResultEntity.ok(iRoleService.list());
  }

  @RequestMapping("/listVo2")
  public ResultEntity listVo2(@RequestParam(defaultValue = "1") long current,
                              @RequestParam(defaultValue = "3") long size,
                              RoleVo vo){
    Page page= new Page(current,size);
    return ResultEntity.ok(iRoleService.selectPageVo2(page,vo));
  }

  @PostMapping("/insert")
  public ResultEntity insert(@RequestBody Role entity){

    return ResultEntity.ok(iRoleService.save(entity));
  }
  @PostMapping("/update")
  public ResultEntity update(@RequestBody Role entity){
    return ResultEntity.ok(iRoleService.updateById(entity));
  }

  @PostMapping("/delete")
  public ResultEntity deletes(Integer rids[]){
    try {
      iRoleService.delete(rids);
      return ResultEntity.ok("物理删除成功");
    } catch (Exception e) {
      e.printStackTrace();
    }
    return ResultEntity.error("物理删除失败");
  }
}

