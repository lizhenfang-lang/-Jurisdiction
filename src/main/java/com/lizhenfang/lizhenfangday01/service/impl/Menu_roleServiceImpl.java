package com.lizhenfang.lizhenfangday01.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lizhenfang.lizhenfangday01.entity.Menu_role;
import com.lizhenfang.lizhenfangday01.mapper.Menu_roleMapper;
import com.lizhenfang.lizhenfangday01.service.IMenu_roleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * <p>
 * InnoDB free: 37888 kB; (`mid`) REFER `vue/menu`(`id`); (`rid`) REFER `vue/role`( 服务实现类
 * </p>
 *
 * @author @李振芳
 * @since 2020-03-30
 */
@Service
public class Menu_roleServiceImpl extends ServiceImpl<Menu_roleMapper, Menu_role> implements IMenu_roleService {
    @Resource
    Menu_roleMapper menu_roleMapper;


    @Override
    public void autorizeRoles(Integer roleId, Integer[] mids) throws Exception {
        //先删除数据
        QueryWrapper wrapper= new QueryWrapper();
        wrapper.eq("rid",roleId);
        menu_roleMapper.delete(wrapper);
        //插入数据
        if (mids!=null && mids.length>0){
            //遍历传递过来的角色的id
            for (int i = 0; i <mids.length ; i++) {
                //创建对象
                Menu_role entity=new Menu_role();
                //设置用户的id
                entity.setRid(roleId);
                //设置用户的角色
                entity.setMid(mids[i]);
                //保存数据
                menu_roleMapper.insert(entity);
            }
        }
    }
}
