package com.learn.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 上传的文件处理工具类
 *
 * @author shenyt
 */
public class MultipartFileUtil {

    public static final Logger logger = LoggerFactory.getLogger(MultipartFileUtil.class);

    /**
     * 根据文件名称获取后缀名
     *
     * @param fileName 文件名称
     * @return 结果
     */
    public static String getSuffix(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }

    /**
     * 获取项目根路径
     *
     * @return 结果
     */
    public static String getRootPath(HttpServletRequest request) {
        String classPath =  request.getSession().getServletContext().getRealPath( "/" );
        String rootPath = "";
        //windows下
        if ("\\".equals(File.separator)) {
//            rootPath = classPath.substring(1, classPath.indexOf("/WEB-INF/classes"));
            rootPath = classPath;
            rootPath = rootPath.replace("/", "\\");
        }
        //linux下
        if ("/".equals(File.separator)) {
            rootPath = classPath.substring(0, classPath.indexOf("/WEB-INF/classes"));
            rootPath = rootPath.replace("\\", "/");
        }
        return rootPath;
    }

    /**
     * 判断文件是否未空，或者没有数据
     *
     * @param file 文件
     * @return 结果
     */
    public static boolean isEmpty(MultipartFile file) {
        return file == null || file.getSize() == 0 || "".equals(file.getOriginalFilename().trim());
    }


    /**
     * 上传文件
     *
     * @param prefix 存放文件的跟路径
     * @param file   文件
     * @return 返回相对路径
     */
    public static String uploadFile(String prefix, MultipartFile file, HttpServletRequest request) {
        prefix = "/cdn/" + prefix;
        //取得当前上传文件的文件名称
        String myFileName = file.getOriginalFilename();
        String suffix = myFileName.substring(myFileName.lastIndexOf(".") + 1);
        //重命名上传后的文件名
        String fileName = UUID.randomUUID().toString() + "." + suffix.toLowerCase();

        //文件夹路径
        String filePath = getRootPath(request) + prefix + "/";
        File f = new File(filePath);
        // 目录已存在创建文件夹
        if (!f.exists()) {
            f.mkdirs();// 目录不存在的情况下，会抛出异常
        }

        //定义上传路径
        String path = filePath + fileName;
        //创建文件
        File localFile = new File(path);
        try {
            file.transferTo(localFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prefix + "/" + fileName;
    }
}
