package com.lizhenfang.lizhenfangday01.mapper;

import com.lizhenfang.lizhenfangday01.entity.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * InnoDB free: 37888 kB Mapper 接口
 * </p>
 *
 * @author @李振芳
 * @since 2020-03-30
 */
public interface MenuMapper extends BaseMapper<Menu> {
        List<Menu> findAll();

       
        List<Menu> findByParentId(Integer parentId);

        List<Menu> findMenuByUsername(String username);
}
