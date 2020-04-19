package com.lizhenfang.lizhenfangday01.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lizhenfang.lizhenfangday01.Vo.ResultEntity;
import com.lizhenfang.lizhenfangday01.entity.User;
import com.lizhenfang.lizhenfangday01.entity.UserVo;
import com.lizhenfang.lizhenfangday01.service.IUserService;
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
@RequestMapping("/user")
public class UserController {
  @Autowired
    private IUserService iUserService;

  @RequestMapping("/listVo")
  public ResultEntity listVo(@RequestParam(defaultValue = "1") long current,
                             @RequestParam(defaultValue = "5") long size,
                             UserVo vo){
      Page page= new Page(current,size);
      return ResultEntity.ok(iUserService.selectPageVo(page,vo));
  }


  @RequestMapping("list")
    public ResultEntity list(@RequestParam(defaultValue = "1") long current,
                             @RequestParam(defaultValue = "5") long size,
                             User entity){//返回的结果,统一是ResultEntity
     Page page= new Page(current,size);
      QueryWrapper<User> queryWrapper=new QueryWrapper<User>();
      if (entity!=null){
          if (entity.getUsername()!=null && !"".equals(entity.getUsername().trim())){
              queryWrapper.like("username",entity.getUsername());
          }
          if (entity.getPhone()!=null && !"".equals(entity.getPhone().trim())){
              queryWrapper.eq("phone",entity.getPhone());
          }
      }
     //成功返回
     return ResultEntity.ok(iUserService.page(page,queryWrapper));
  }
    @PostMapping("/insert")
    public ResultEntity insert(@RequestBody User entity){
        entity.setPassword("123");
      return ResultEntity.ok(iUserService.save(entity));
    }

    @PostMapping("/update")
    public ResultEntity update(@RequestBody User entity){

        return ResultEntity.ok(iUserService.updateById(entity));
    }

    @PostMapping("/delete")
    public ResultEntity update(Integer uids[]){
        try {
            iUserService.update(uids);
            return ResultEntity.ok("更新成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultEntity.error("更新失败");
    }
    @PostMapping("/deletes")
    public ResultEntity deletes(Integer uids[]){
        try {
            iUserService.delete(uids);
            return ResultEntity.ok("物理删除成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultEntity.error("物理删除失败");
    }
    @RequestMapping("/login")
    public ResultEntity login(String username,String password){
      //定义查询对象
        QueryWrapper wrapper=new QueryWrapper();
        //设置查询条件
        wrapper.eq("username",username);
        //执行查询效果
        User entity=iUserService.getOne(wrapper);
        //判断
        if (entity!=null){
            //判断密码  用户密码正确
            if ((entity.getPassword().equals(password))){
                //返回结果
                return  ResultEntity.ok(entity);
            }
        }
        return ResultEntity.error("用户或密码错误");
    }

    @PostMapping("updatePassword")
    public ResultEntity updatePassword(Integer id,String password){
      return ResultEntity.ok(iUserService.updatePassword(id,password));
    }

}

