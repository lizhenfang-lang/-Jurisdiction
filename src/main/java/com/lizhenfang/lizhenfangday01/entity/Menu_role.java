package com.lizhenfang.lizhenfangday01.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * InnoDB free: 37888 kB; (`mid`) REFER `vue/menu`(`id`); (`rid`) REFER `vue/role`(
 * </p>
 *
 * @author @李振芳
 * @since 2020-03-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Menu_role implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer mid;

    private Integer rid;


}
