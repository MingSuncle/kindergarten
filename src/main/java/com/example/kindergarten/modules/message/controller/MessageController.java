package com.example.kindergarten.modules.message.controller;





import com.example.kindergarten.common.utils.R;
import com.example.kindergarten.modules.message.dao.MessageDao;
import com.example.kindergarten.modules.message.entity.Message;

import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "AI消息")
@ApiSupport(order = 20)
@RestController
@RequestMapping("/DataManage")

public class MessageController {

    @Autowired
    private MessageDao MessageDao;

    @ApiOperation("测试用")
    @GetMapping("/getAll")
    public R currentUnfinished() {
        R r = R.ok();
        List<Message> result = MessageDao.getAll();
        r.put("result",result);
        return r;
    }


}
