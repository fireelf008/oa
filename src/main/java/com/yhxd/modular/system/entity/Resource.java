package com.yhxd.modular.system.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 资源
 * @author wsf
 */
@Data
@Entity(name = "sys_resource")
@EntityListeners(value = AuditingEntityListener.class)
public class Resource implements Serializable {

    @ApiModelProperty(value = "id")
    @Id
    @GeneratedValue(generator = "idGenerator")
    @GenericGenerator(name = "idGenerator", strategy = "com.yhxd.utils.IdUtils")
    @Column(name = "id")
    private Long id;

    @ApiModelProperty(value = "资源code")
    @Column(name = "res_code")
    private String resCode;

    @ApiModelProperty(value = "资源名称")
    @Column(name = "res_name")
    private String resName;

    @ApiModelProperty(value = "资源url")
    @Column(name = "url")
    private String url;

    @ApiModelProperty(value = "资源排序")
    @Column(name = "sort")
    private Integer sort;

    @ApiModelProperty(value = "资源图标")
    @Column(name = "icon")
    private String icon;

    @ApiModelProperty(value = "资源类型，0菜单，1按钮")
    @Column(name = "type")
    private Integer type;

    @ApiModelProperty(value = "父资源id")
    @Column(name = "pid")
    private Long pid;

    @ApiModelProperty(value = "创建人")
    @Column(name = "create_name")
    private String createName;

    @ApiModelProperty(value = "创建时间")
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @Column(name = "create_time")
    private Date createTime;

    @ApiModelProperty(value = "修改人")
    @Column(name = "update_name")
    private String updateName;

    @ApiModelProperty(value = "修改时间")
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    @Column(name = "update_time")
    private Date updateTime;

    @ApiModelProperty(value = "数据是否可用，0不可用，1可用")
    @Column(name = "enable")
    private Integer enable = 1;

    @ApiModelProperty(value = "版本号")
    @Column(name = "version")
    private Integer version;

    @Transient
    private List<Resource> childResourceList;
}
