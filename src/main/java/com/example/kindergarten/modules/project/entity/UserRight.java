package com.example.kindergarten.modules.project.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.github.jeffreyning.mybatisplus.anno.MppMultiId;
import lombok.Data;


@Data
@TableName("user_right")
public class UserRight {

    @MppMultiId
    @TableField(value = "user_id")
    private Integer userId;

    @MppMultiId
    @TableField(value = "project_id")
    private String projectId;

    @MppMultiId
    @TableField(value = "video_id")
    private String videoId;

    @TableField(value = "AI_list")
    private  String AIList;
}
