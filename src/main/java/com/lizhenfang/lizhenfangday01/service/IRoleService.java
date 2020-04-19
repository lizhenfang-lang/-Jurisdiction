package com.lizhenfang.lizhenfangday01.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lizhenfang.lizhenfangday01.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lizhenfang.lizhenfangday01.entity.RoleVo;
import com.lizhenfang.lizhenfangday01.entity.UserVo;

/**
 * <p>
 * InnoDB free: 37888 kB 服务类
 * </p>
 *
 * @author @李振芳
 * @since 2020-03-30
 */
public interface IRoleService extends IService<Role> {
    IPage<RoleVo> selectPageVo2(Page page, RoleVo vo);

    void delete(Integer[] rids)throws  Exception;
}
