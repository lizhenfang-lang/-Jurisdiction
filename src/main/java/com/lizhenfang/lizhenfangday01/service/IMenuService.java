package com.lizhenfang.lizhenfangday01.service;

import com.lizhenfang.lizhenfangday01.entity.Menu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * InnoDB free: 37888 kB 服务类
 * </p>
 *
 * @author @李振芳
 * @since 2020-03-30
 */
public interface IMenuService extends IService<Menu> {
    List<Menu> findAll();


    List<Menu> findMenuByUsername(String username);

    List<Menu> findByParentId(Integer parentId);
}
