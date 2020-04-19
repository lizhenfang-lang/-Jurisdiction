package com.lizhenfang.lizhenfangday01;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lizhenfang.lizhenfangday01.entity.Menu;
import com.lizhenfang.lizhenfangday01.entity.UserVo;
import com.lizhenfang.lizhenfangday01.mapper.MenuMapper;
import com.lizhenfang.lizhenfangday01.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class LizhenfangDay01ApplicationTests {
    @Resource
    MenuMapper menuMapper;

    @Resource
    private UserMapper userMapper;
    @Test
    void contextLoads() {
      List<Menu> menus= menuMapper.findByParentId(0);
        System.out.println(menus);
    }

    @Test
    void contextLoads1() {
        UserVo vo = new UserVo();
        vo.setRids("1,4");
        userMapper.selectPageVo(new Page(1,3),vo);
    }

}
