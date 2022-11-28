package com.example.kindergarten.modules.equipment.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("video_config")
public class Video {
    @TableId("video_id")
    private String videoId;

    @TableField("video_ip")
    private String videoIp;

    @TableField("video_fps")
    private Double videoFps;

    @TableField("video_brand")
    private String videoBrand;

    @TableField("video_position")
    private String videoPosition;

    @TableField("video_username")
    private String videoUsername;

    @TableField("video_name")
    private String videoName;

    @TableField("video_port")
    private String videoPort;

    @TableField("video_stream")
    private String videoStream;

    @TableField("state")
    private Integer state;

    @TableField("box_id")
    private String boxId;
}
