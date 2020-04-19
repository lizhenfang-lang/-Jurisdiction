package com.lizhenfang.lizhenfangday01.controller;


import com.lizhenfang.lizhenfangday01.Vo.ResultEntity;
import com.lizhenfang.lizhenfangday01.service.IMenu_roleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * InnoDB free: 37888 kB; (`mid`) REFER `vue/menu`(`id`); (`rid`) REFER `vue/role`( 前端控制器
 * </p>
 *
 * @author @李振芳
 * @since 2020-03-30
 */
@RestController
@RequestMapping("/menu_role")
public class Menu_roleController {
    @Autowired
    private IMenu_roleService iMenu_roleService;
    @RequestMapping("/insert")
    public ResultEntity save(Integer roleId, @RequestParam(value = "mids[]") Integer mids[]){
        try {
            iMenu_roleService.autorizeRoles(roleId,mids);
            return  ResultEntity.ok("授权成功！");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultEntity.error("授权失败！");
    }

}

