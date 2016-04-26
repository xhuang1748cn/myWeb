package cn.srn.controllers;

import cn.srn.respson.ResponseInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by SRn on 2016/4/26.
 */
@Controller
public class Uploader {

    private static final Logger log = LoggerFactory.getLogger(Uploader.class);

    /**
     * 上传文件
     * 在前台的访问路径为： http://localhost:8080/springmvc/widget/uploadFile/view
     * @return
     */
    @RequestMapping("/uploadFile")
    public String uploadFile() {
        return "upload/uploadFile";
    }

    @ResponseBody
    @RequestMapping(value="/saveFile", method= RequestMethod.POST)
    public ResponseInfo saveFile(@RequestParam MultipartFile file,
                                @RequestParam String projectName,
                                 HttpSession session) {
        ResponseInfo view = new ResponseInfo();
        String orgiginalFileName = "";
        try {
            String fileName = file.getName();
            InputStream inputStream = file.getInputStream();
            String content = file.getContentType();
            orgiginalFileName = file.getOriginalFilename();
            log.info("fileName: " + fileName + ", inputStream: " + inputStream
                    + "\r\n content: " + content + ", orgiginalFileName: =" + orgiginalFileName
                    + "\r\n projectName: " + projectName);
            String outPath = session.getServletContext().getRealPath("/upload");
            if (outPath != null) {
                File targetFile = new File(outPath, orgiginalFileName);
                try {
                    file.transferTo(targetFile);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        view.setCode(0);
        view.setMessage("上传: " + orgiginalFileName + " 文件成功！");
        return view;
    }
}
