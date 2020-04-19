package com.lizhenfang.lizhenfangday01.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lizhenfang.lizhenfangday01.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lizhenfang.lizhenfangday01.entity.UserVo;

/**
 * <p>
 * InnoDB free: 37888 kB 服务类
 * </p>
 *
 * @author @李振芳
 * @since 2020-03-30
 */
public interface IUserService extends IService<User> {
    IPage<UserVo> selectPageVo(Page page, UserVo vo);

    /**
     * 批量更新  逻辑删除
     * @param uids
     * @throws Exception
     */
    void update(Integer uids[]) throws  Exception;

    /**
     * 物理删除
     * @param uids
     * @throws Exception
     */
    void delete(Integer uids[]) throws  Exception;

    boolean updatePassword(Integer id, String password);
}
