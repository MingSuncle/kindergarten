package com.example.kindergarten.modules.project.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;

@Data
@TableName("project")

public class Project implements Serializable {
    private static final long serialVersionUID = 1L ;

    @TableId(value = "project_id")
    private String projectId;

    @TableField(value = "project_name")
    private String projectName;

    @TableField(value = "project_position")
    private String projectPosition;

    @TableField(value = "project_description")
    private String projectDescription;
}
