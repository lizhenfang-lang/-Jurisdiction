package com.lizhenfang.lizhenfangday01.mapper;

import com.lizhenfang.lizhenfangday01.entity.Nation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 城市字典表; InnoDB free: 37888 kB Mapper 接口
 * </p>
 *
 * @author @李振芳
 * @since 2020-03-30
 */
public interface NationMapper extends BaseMapper<Nation> {
     List<Nation> findAll();
}
