package com.lizhenfang.lizhenfangday01.service.impl;

import com.lizhenfang.lizhenfangday01.entity.Nation;
import com.lizhenfang.lizhenfangday01.mapper.NationMapper;
import com.lizhenfang.lizhenfangday01.service.INationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 城市字典表; InnoDB free: 37888 kB 服务实现类
 * </p>
 *
 * @author @李振芳
 * @since 2020-03-30
 */
@Service
public class NationServiceImpl extends ServiceImpl<NationMapper, Nation> implements INationService {
   @Resource
   NationMapper nationMapper;

    @Override
    public List<Nation> findAll() {
        return nationMapper.findAll();
    }
}
