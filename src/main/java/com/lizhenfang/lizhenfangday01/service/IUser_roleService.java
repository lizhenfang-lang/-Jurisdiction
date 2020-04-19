package com.lizhenfang.lizhenfangday01.service;

import com.lizhenfang.lizhenfangday01.entity.User_role;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * InnoDB free: 37888 kB; (`uid`) REFER `vue/user`(`id`) ON DELETE CASCADE; (`rid`) 服务类
 * </p>
 *
 * @author @李振芳
 * @since 2020-03-30
 */
public interface IUser_roleService extends IService<User_role> {
  //授权角色
   void autorizeRoles(Integer uid, Integer rids[])throws Exception;
}
