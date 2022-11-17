package com.example.kindergarten.modules.equipment.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("AIevent")
public class Event implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "AIevent_id" , type = IdType.AUTO)
    private Integer AIeventId;

    @TableField(value = "AIevent_name")
    private String AIeventName;

    @TableField(value = "AIevent_description")
    private String AIeventDescription;

    @TableField(value = "AImodel_name")
    private String AImodelName;

}
