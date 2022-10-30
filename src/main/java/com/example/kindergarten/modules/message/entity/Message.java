package com.example.kindergarten.modules.message.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("AImessage")

public class Message  implements Serializable{
    private static final long serialVersionUID = 1L;

    @TableId(value = "message_id" , type = IdType.AUTO)
    private Long messageId;

    @TableField(value = "project_id")
    private String projectId;

    @TableField(value = "box_id")
    private String boxId;

    @TableField(value = "box_ip")
    private String boxIp;

    @TableField(value = "video_ip")
    private String videoIp;

    @TableField(value = "video_id")
    private String videoId;

    @TableField(value = "AIevent_name")
    private String AIeventName;

    @TableField(value = "description")
    private String description;


    @TableField(value = "file")
    private String file;

    @TableField(value = "file_type")
    private Integer fileType;

    @TableField(value = "time")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time;


    @TableField(value = "level")
    private String level;

    @TableField(value = "method")
    private Integer method;

    @TableField(value = "param")
    private String param;

    @TableField(value = "location")
    private String location;

}
