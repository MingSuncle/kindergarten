package com.example.kindergarten.modules.message.controller;





import com.example.kindergarten.common.utils.R;
import com.example.kindergarten.modules.message.dao.MessageDao;
import com.example.kindergarten.modules.message.entity.Message;

import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
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
    public R getAll() {
        R r = R.ok();
        List<Message> result = MessageDao.getAll();
        r.put("result",result);
        return r;
    }

    @ApiOperation("条件查询")
    @GetMapping("/find")
    public R findMessage(
            @RequestParam(value = "usr_id",required = false) String usrId,
            @RequestParam(value = "pro_id",required = false) LinkedList<String> proId,
            @RequestParam(value = "begin_time",required = false) String beginTime,
            @RequestParam(value = "end_time",required = false) String endTime,
            @RequestParam(value = "event_type",required = false) LinkedList<String> type,
            @RequestParam(value = "current_page",required = false) Integer currentPage,
            @RequestParam(value = "page_size",required = false) Integer pageSize) {
        R r = R.ok();

        while (proId != null && !proId.isEmpty()) {
            if (StringUtils.isBlank(proId.getLast())) {
                proId.removeLast();
            } else {
                break;
            }
        }
        while (type != null && !type.isEmpty()) {
            if (StringUtils.isBlank(type.getLast())) {
                type.removeLast();
            } else {
                break;
            }
        }
        if (proId != null && proId.isEmpty()) {
            proId = null;
        }

        if (type != null && type.isEmpty()) {
            type = null;
        }
        List<Message> list = MessageDao.findMessage(usrId, proId,  beginTime, endTime, type, (currentPage - 1) * pageSize, pageSize);
        Integer totalNum = MessageDao.MessageNum(usrId, proId,  beginTime, endTime, type);
        r.put("result", list);
        r.put("totalNum",totalNum);
        return r;
    }


}
