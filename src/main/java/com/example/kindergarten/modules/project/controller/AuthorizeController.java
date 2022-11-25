package com.example.kindergarten.modules.project.controller;

import com.example.kindergarten.common.utils.R;


import com.example.kindergarten.modules.project.dao.AuthorizeDao;
import com.example.kindergarten.modules.project.entity.UserRight;
import com.github.jeffreyning.mybatisplus.conf.EnableMPP;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "授权相关")
@ApiSupport(order = 30)
@RestController
@EnableMPP
@RequestMapping("/Authorize")
public class AuthorizeController {
    @Autowired
    private AuthorizeDao AuthorizeDao;

    @ApiOperation("查看所有授权条目")
    @GetMapping("/getAll")
    public R getAll(@RequestParam(value = "currentPage") Integer currentPage,
                    @RequestParam(value = "pageSize") Integer pageSize
    ){
        R r = R.ok();
        List<UserRight> result = AuthorizeDao.getAll((currentPage - 1) * pageSize,pageSize);
        Integer totalNum = AuthorizeDao.totalNum();
        r.put("result",result);
        r.put("totalNum",totalNum);
        return r;
    }

    @ApiOperation("条件查看")
    @GetMapping("/find")
    public R find(@RequestParam(value = "userId",required = false) Integer userId,
                  @RequestParam(value = "projectId",required = false) String projectId){
        R r = R.ok();
        if (projectId != null && projectId.isEmpty()) {
            projectId = null;
        }

        List<UserRight> result = AuthorizeDao.find(userId,projectId);
        Integer totalNum = AuthorizeDao.totalNum();
        r.put("result",result);
        r.put("totalNum",totalNum);
        return r;

    }

}
