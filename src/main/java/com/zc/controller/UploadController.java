package com.zc.controller;

import com.zc.service.impl.ProjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UploadController {

    @Autowired
    private ProjectServiceImpl projectService;
    SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd/");

    @PostMapping("/upload")
    public Map<String, Object> fileUpload(MultipartFile file, HttpServletRequest request) throws Exception {
        Map<String, Object> result = new HashMap<>();
        String originalFilename = file.getOriginalFilename();
        /*if (!originalFilename.endsWith(".pdf")) {
            result.put("status", "error");
            result.put("msg", "文件类型错误");
            return result;
        }*/
        String format = sdf.format(new Date());
        String realPath = request.getServletContext().getRealPath("/") + format;
//        String realPath = ResourceUtils.getURL("classpath:").getPath() + "/static/" + format;


        System.out.println(realPath);
        File folder = new File(realPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        String oldName = file.getOriginalFilename();
//        String newName = UUID.randomUUID() + oldName.substring(oldName.lastIndexOf("."));
        try {
            file.transferTo(new File(folder, oldName));
            String url = request.getScheme()
                    + "://" + request.getServerName() + ":" + request.getServerPort() + format + oldName;

//            String url = realPath + oldName;
            System.out.println(url);
            result.put("status", "success");
            result.put("url", url);
            result.put("code", 0);
        } catch (Exception e) {
            result.put("status", "error");
            result.put("msg", e.getMessage());
        }

        System.out.println(result);
        return result;
    }
}
