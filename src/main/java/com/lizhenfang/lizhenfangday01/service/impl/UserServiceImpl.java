package com.lizhenfang.lizhenfangday01.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lizhenfang.lizhenfangday01.entity.User;
import com.lizhenfang.lizhenfangday01.entity.UserVo;
import com.lizhenfang.lizhenfangday01.mapper.UserMapper;
import com.lizhenfang.lizhenfangday01.mapper.User_roleMapper;
import com.lizhenfang.lizhenfangday01.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.lang.reflect.Array;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * <p>
 * InnoDB free: 37888 kB 服务实现类
 * </p>
 *
 * @author @李振芳
 * @since 2020-03-30
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    //声明日志对象
    private Logger logger= LoggerFactory.getLogger(UserServiceImpl.class);
    @Resource
    private User_roleMapper user_roleMapper;
    @Resource
    private  UserMapper userMapper;

    @Override
    public IPage<UserVo> selectPageVo(Page page, UserVo vo) {
        return userMapper.selectPageVo(page,vo);
    }

    @Override
    @Transactional
    public void update(Integer[] uids) throws Exception {
        for (Integer uid:uids){
            User entity=  userMapper.selectById(uid);
            entity.setEnabled(false);
            userMapper.updateById(entity);
        }
    }
    @Transactional
    @Override
    public void delete(Integer[] uids) throws Exception {
        logger.info("先解除关联关系，先删除中间表的数据");
       //判断
        if (uids!=null && uids.length>0){
           //循环一个一个删除中间表
            for(Integer uid:uids){
               QueryWrapper wrapper=new QueryWrapper();
               wrapper.eq("uid",uid);
               user_roleMapper.delete(wrapper);
           }
           userMapper.deleteBatchIds(Arrays.asList(uids));
       }
    }

    @Override
    public boolean updatePassword(Integer id, String password) {
        return userMapper.updatePassword(id,password);
    }


}
