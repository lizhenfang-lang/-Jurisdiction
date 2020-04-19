package com.lizhenfang.lizhenfangday01.service;

import com.lizhenfang.lizhenfangday01.entity.Nation;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 城市字典表; InnoDB free: 37888 kB 服务类
 * </p>
 *
 * @author @李振芳
 * @since 2020-03-30
 */
public interface INationService extends IService<Nation> {
    List<Nation> findAll();
}
