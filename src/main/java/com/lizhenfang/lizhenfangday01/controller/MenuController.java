package com.lizhenfang.lizhenfangday01.controller;


import com.lizhenfang.lizhenfangday01.Vo.ResultEntity;
import com.lizhenfang.lizhenfangday01.entity.Menu;
import com.lizhenfang.lizhenfangday01.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * InnoDB free: 37888 kB 前端控制器
 * </p>
 *
 * @author @李振芳
 * @since 2020-03-30
 */
@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private IMenuService iMenuService;

    @RequestMapping("/findAll")
    public ResultEntity findAll(){
        return ResultEntity.ok(iMenuService.list());
    }

    @RequestMapping("/findAll2")
    public List<Menu> findAll2(){
        return iMenuService.findAll();
    }

    @RequestMapping("/findMenuByUsername")
    public List<Menu> findMenuByUsername(String username){
        return iMenuService.findMenuByUsername(username);
    }

    @RequestMapping("/tree")
    public List<Menu> tree(){
        return iMenuService.findByParentId(0);
    }


}

