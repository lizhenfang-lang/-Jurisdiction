package com.lizhenfang.lizhenfangday01.service;

import com.lizhenfang.lizhenfangday01.entity.Menu_role;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * InnoDB free: 37888 kB; (`mid`) REFER `vue/menu`(`id`); (`rid`) REFER `vue/role`( 服务类
 * </p>
 *
 * @author @李振芳
 * @since 2020-03-30
 */
public interface IMenu_roleService extends IService<Menu_role> {

    void autorizeRoles(Integer roleId, Integer mids[])throws Exception;


}
