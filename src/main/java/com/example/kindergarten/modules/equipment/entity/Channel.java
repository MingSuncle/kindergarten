package com.example.kindergarten.modules.equipment.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("channel_config")
public class Channel {
    private static final long serialVersionUID =1L;

    @TableId(value = "channel_id")
    private String channelId;

    @TableField(value = "channel_name")
    private String channelName;

    @TableField(value = "video_id")
    private String videoId;

    @TableField(value = "event_id")
    private Integer eventId;

    @TableField(value = "box_id")
    private String boxId;

    @TableField(value = "state")
    private Integer state;
}
