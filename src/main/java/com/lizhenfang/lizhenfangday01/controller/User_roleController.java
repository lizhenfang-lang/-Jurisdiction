package com.lizhenfang.lizhenfangday01.controller;


import com.lizhenfang.lizhenfangday01.Vo.ResultEntity;
import com.lizhenfang.lizhenfangday01.service.IUser_roleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * InnoDB free: 37888 kB; (`uid`) REFER `vue/user`(`id`) ON DELETE CASCADE; (`rid`) 前端控制器
 * </p>
 *
 * @author @李振芳
 * @since 2020-03-30
 */
@RestController
@RequestMapping("/user_role")
public class User_roleController {
  @Autowired
    private IUser_roleService iUser_roleService;

  @RequestMapping("/insert")
    public ResultEntity save(Integer uid,@RequestParam(value = "rids[]") Integer rids[]){
      try {
          iUser_roleService.autorizeRoles(uid,rids);
          return  ResultEntity.ok("授权成功！");
      } catch (Exception e) {
          e.printStackTrace();
      }
      return ResultEntity.error("授权失败！");
  }
}

