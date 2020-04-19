package com.lizhenfang.lizhenfangday01.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * InnoDB free: 37888 kB
 * </p>
 *
 * @author @李振芳
 * @since 2020-03-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Menu implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String url;

    private String path;

    private String component;


    private String name;
    @TableField("iconCls")
    private String iconCls;
    @TableField("keepAlive")
    private Boolean keepAlive;
    @TableField("requireAuth")
    private Boolean requireAuth;
    @TableField("parentId")
    private Integer parentId;

    private Boolean enabled;

    private Date create_time;

   //直接在实体bean扩展属性
   @TableField(exist = false)
    List<Menu> subMenus;
}
