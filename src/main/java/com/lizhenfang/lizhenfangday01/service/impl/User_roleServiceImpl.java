package com.lizhenfang.lizhenfangday01.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lizhenfang.lizhenfangday01.entity.User_role;
import com.lizhenfang.lizhenfangday01.mapper.User_roleMapper;
import com.lizhenfang.lizhenfangday01.service.IUser_roleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * <p>
 * InnoDB free: 37888 kB; (`uid`) REFER `vue/user`(`id`) ON DELETE CASCADE; (`rid`) 服务实现类
 * </p>
 *
 * @author @李振芳
 * @since 2020-03-30
 */
@Service
public class User_roleServiceImpl extends ServiceImpl<User_roleMapper, User_role> implements IUser_roleService {
    //创建日志对象
    private Logger logger= LoggerFactory.getLogger(User_roleServiceImpl.class);
    @Resource
    private User_roleMapper user_roleMapper;

    @Transactional  //事务注解  回滚
    @Override
    public void autorizeRoles(Integer uid, Integer[] rids) throws Exception {
         logger.info("事务开始@@@@@@@@@@@@");
         //先删除数据
       QueryWrapper wrapper= new QueryWrapper();
       wrapper.eq("uid",uid);
       //插入数据
        if (rids!=null && rids.length>0){
            //遍历传递过来的角色的id
            for (int i = 0; i <rids.length ; i++) {
                //创建对象
                User_role entity=new User_role();
                //设置用户的id
                entity.setUid(uid);
                //设置用户的角色
                entity.setRid(rids[i]);
                //保存数据
                user_roleMapper.insert(entity);
            }
        }
        logger.info("事务结束@@@@@@@@@@@@");
    }
}
