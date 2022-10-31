package com.example.kindergarten.modules.project.controller;


import com.example.kindergarten.common.utils.R;
import com.example.kindergarten.modules.project.dao.ProjectDao;
import com.example.kindergarten.modules.project.entity.Project;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "项目相关")
@ApiSupport(order = 20)
@RestController
@RequestMapping("/ProjectManage")

public class ProjectController {
    @Autowired
    private ProjectDao ProjectDao;

    @ApiOperation("查看所有项目")
    @GetMapping("/getAll")
    public R getAll(){
        R r = R.ok();
        List<Project> result = ProjectDao.getAll();
        Integer totalNum = result.size();
        r.put("result",result);
        r.put("totalNum",totalNum);
        return r;
    }

    @ApiOperation("新建项目")
    @PostMapping("/addProject")
    public R addProject(@RequestBody Project project){
        R r = R.ok();
        Integer I  = ProjectDao.insert(project);
        r.put("result","success");
        return r;
    }

    @ApiOperation("删除项目")
    @GetMapping("/delete")
    public R deleteProject(@RequestParam String projectId){
        R r = R.ok();
        Integer I = ProjectDao.deleteById(projectId);
        r.put("result","success");
        return r;
    }
}
