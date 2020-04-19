package com.lizhenfang.lizhenfangday01.service.impl;

import com.lizhenfang.lizhenfangday01.entity.Menu;
import com.lizhenfang.lizhenfangday01.mapper.MenuMapper;
import com.lizhenfang.lizhenfangday01.service.IMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * InnoDB free: 37888 kB 服务实现类
 * </p>
 *
 * @author @李振芳
 * @since 2020-03-30
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {
    @Resource
    MenuMapper menuMapper;
    @Override
    public List<Menu> findAll() {
        return menuMapper.findAll();
    }

    @Override
    public List<Menu> findMenuByUsername(String username) {
        return menuMapper.findMenuByUsername(username);
    }

    @Override
    public List<Menu> findByParentId(Integer parentId) {
        return menuMapper.findByParentId(parentId);
    }
}
