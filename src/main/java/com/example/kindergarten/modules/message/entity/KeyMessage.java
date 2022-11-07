package com.example.kindergarten.modules.message.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("AImessage_vip")
public class KeyMessage implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "message_id")
    private Long messageId;

    @TableField(value = "user_id")
    private Long userId;

    @TableField(value = "time")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time;

}
