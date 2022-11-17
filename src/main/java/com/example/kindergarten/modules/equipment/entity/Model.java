package com.example.kindergarten.modules.equipment.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("model")
public class Model implements Serializable {
    private static  final long serialVersionUID = 1L;

    @TableId(value  = "model_version")
    private String modelVersion;

    @TableField(value = "model_file")
    private String modelFile;


}
