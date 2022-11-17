package com.example.kindergarten.modules.equipment.controller;

import com.example.kindergarten.common.utils.R;
import com.example.kindergarten.modules.equipment.dao.ModelDao;
import com.example.kindergarten.modules.equipment.entity.Model;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;


@Api(tags = "文件相关")
@ApiSupport(order = 10)
@RestController
@RequestMapping("/file")
public class FileController {
    @Autowired
    private ModelDao modelDao;
    @ApiOperation("下载模板")
    @GetMapping("/download")
    public String download(HttpServletResponse response) {

        try {
//            String path = "/root/antipidemic/Excel/template/staffTemplate.xlsx";
            String path = "D:/Zhaozian/get_aibox_config.json";
            // path是指想要下载的文件的路径
            File file = new File(path);
            System.out.println(file.getPath());
            // 获取文件名
            String filename = file.getName();
            // 获取文件后缀名
            String ext = filename.substring(filename.lastIndexOf(".") + 1).toLowerCase();
            System.out.println("文件后缀名：" + ext);

            // 将文件写入输入流
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStream fis = new BufferedInputStream(fileInputStream);
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();

            // 清空response
            response.reset();
            // 设置response的Header
            response.setCharacterEncoding("UTF-8");
            //Content-Disposition的作用：告知浏览器以何种方式显示响应返回的文件，用浏览器打开还是以附件的形式下载到本地保存
            //attachment表示以附件方式下载 inline表示在线打开 "Content-Disposition: inline; filename=文件名.mp3"
            // filename表示文件的默认名称，因为网络传输只支持URL编码的相关支付，因此需要将文件名URL编码后进行传输,前端收到后需要反编码才能获取到真正的名称
            response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8"));
            // 告知浏览器文件的大小
            response.addHeader("Content-Length", "" + file.length());
            OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            outputStream.write(buffer);
            outputStream.flush();
            return "sucess";
        } catch (IOException ex) {
            ex.printStackTrace();
            return "fail";
        }
    }

    @ApiOperation("上传模型文件")
    @PostMapping("/uploadModel")
    @ApiOperationSupport(order=20)
    public R uploadFile(@RequestParam MultipartFile file,
                        @RequestParam String version)throws Exception{
        R r =R.ok();
        try {
            String filePath = "D:/Zhaozian/datatest/";
//            String filePath ="/root/model_directory/";
            String fileName = System.currentTimeMillis() + file.getOriginalFilename();

            // 上传文件
            File f = new File(filePath + fileName);
            file.transferTo(f);

//          数据库中存储文件路径
            String fileurl = "http://47.100.71.212:8080/"+fileName;
            Model model = new Model();
            model.setModelFile(fileurl);
            model.setModelVersion(version);
            modelDao.insert(model);

            r.put("result","success");
            return r;
        }catch (Exception e){
            System.out.println(e);
            r.put("result","fail");
            return r;
        }

    }

}
