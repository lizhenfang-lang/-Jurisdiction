package com.lizhenfang.lizhenfangday01.controller;


import com.lizhenfang.lizhenfangday01.entity.Nation;
import com.lizhenfang.lizhenfangday01.service.INationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 城市字典表; InnoDB free: 37888 kB 前端控制器
 * </p>
 *
 * @author @李振芳
 * @since 2020-03-30
 */
@RestController
@RequestMapping("/nation")
public class NationController {
   @Autowired
    private INationService iNationService;

   @RequestMapping("/list")
   public List<Nation> findAll(){
       return iNationService.findAll();
   }
}

