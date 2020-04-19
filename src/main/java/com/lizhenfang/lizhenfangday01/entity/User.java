package com.lizhenfang.lizhenfangday01.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

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
public class User implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * hrID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 住宅电话
     */
    private String telephone;

    /**
     * 联系地址
     */
    private String address;

    private Boolean enabled;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    private String userface;

    private String remark;

    private Integer sex;

    /**
     * 省
     */
    private Integer province;

    /**
     * 城市
     */
    private Integer city;

    /**
     * 区县
     */
    private Integer district;

    private  String title;
    private  String url;

    private  String created;


}
