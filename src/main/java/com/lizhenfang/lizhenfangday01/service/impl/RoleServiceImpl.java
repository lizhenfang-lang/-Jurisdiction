package com.lizhenfang.lizhenfangday01.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lizhenfang.lizhenfangday01.entity.Role;
import com.lizhenfang.lizhenfangday01.entity.RoleVo;

import com.lizhenfang.lizhenfangday01.mapper.Menu_roleMapper;
import com.lizhenfang.lizhenfangday01.mapper.RoleMapper;
import com.lizhenfang.lizhenfangday01.mapper.User_roleMapper;
import com.lizhenfang.lizhenfangday01.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * <p>
 * InnoDB free: 37888 kB 服务实现类
 * </p>
 *
 * @author @李振芳
 * @since 2020-03-30
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {
 @Resource
 private  RoleMapper roleMapper;

 @Resource
 private Menu_roleMapper menu_roleMapper;
    @Resource
    private User_roleMapper user_roleMapper;

    @Override
    public IPage<RoleVo> selectPageVo2(Page page, RoleVo vo) {
        return roleMapper.selectPageVo2(page,vo);
    }

    @Transactional
    @Override
    public void delete(Integer[] rids) throws Exception {

        //判断
        if (rids!=null && rids.length>0){
            //循环一个一个删除中间表
            for(Integer rid:rids){
                QueryWrapper wrapper=new QueryWrapper();
                wrapper.eq("rid",rid);
                menu_roleMapper.delete(wrapper);
                user_roleMapper.delete(wrapper);
            }
            roleMapper.deleteBatchIds(Arrays.asList(rids));
        }
    }


}
