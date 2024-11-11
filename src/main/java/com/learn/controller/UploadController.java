package com.learn.controller;

import com.learn.utils.MultipartFileUtil;
import com.learn.utils.R;
import com.learn.utils.RRException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * 文件上传
 *
 * @author shenyt
 * @email syt12322@163.com
 * @date 2018-03-25 12:13:26
 */
@RestController
@RequestMapping("file")
public class UploadController {

    public static String[] suffixs = {"IMG", "PNG", "JPG", "JPEG", "GIF", "BPM"};

    /**
     * 上传文件
     */
    @RequestMapping("/upload")
    public R upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws Exception {
        if (file.isEmpty()) {
            throw new RRException("上传文件不能为空");
        }
        String url = MultipartFileUtil.uploadFile("/cdn", file, request);
        return R.ok().put("url", url);
    }


    /**
     * 上传资讯内容的图片
     *
     * @param upload   图片
     * @param response 响应
     */
    @ResponseBody
    @RequestMapping("ckEditorUpload")
    public void uploadFile(MultipartFile upload, String CKEditorFuncNum, HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            String path = null;

            if (upload != null && !upload.isEmpty()) {

                String url = MultipartFileUtil.uploadFile("/cdn", upload, request);
                path = url;
            }


            // 返回“图像”选项卡并显示图片
            out.println("<script type=\"text/javascript\">");
            out.println("window.parent.CKEDITOR.tools.callFunction(" + CKEditorFuncNum + ",'" + path + "','')");
            out.println("</script>");

        } catch (RuntimeException e) {
            out.println("<script type=\"text/javascript\">");
            out.println("window.parent.CKEDITOR.tools.callFunction(" + CKEditorFuncNum + ",'','" + e.getMessage() + "');");
            out.println("</script>");
        }
    }


}
