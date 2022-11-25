package com.example.kindergarten.modules.equipment.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("box_config")
public class Box implements Serializable {
    private static final long serialVersionUID =1L;

    @TableId(value = "box_id")
    private String boxId;

    @TableField(value = "box_name")
    private String boxName;

    @TableField(value = "box_ip")
    private String boxIp;

    @TableField(value = "project_id")
    private String projectId;

    @TableField(value = "setting_file")
    private String settingFile;

    @TableField(value = "setting_file_version")
    private String settingFileVersion;

    @TableField(value = "model_file")
    private String modelFile;

    @TableField(value = "model_file_version")
    private String modelFileVersion;

    @TableField(value = "state")
    private Integer state;

    @TableField(exist = false)
    private String projectName;

}
