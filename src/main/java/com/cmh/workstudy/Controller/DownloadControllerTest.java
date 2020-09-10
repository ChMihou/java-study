package com.cmh.workstudy.Controller;

import com.cmh.workstudy.utils.FastDFSClientWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class DownloadControllerTest {

    @Autowired
    private FastDFSClientWrapper dfsClient;

    @RequestMapping("file")
    public String file()
    {
        return "file";
    }

    // 上传文件
    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public String upload(@RequestParam("file") MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println(file.getName());
        System.out.println(file.getInputStream());
        System.out.println(file.getSize());
        String fileUrl= dfsClient.uploadFile(file);
        return fileUrl;
    }

}

