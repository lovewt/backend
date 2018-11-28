package com.dcmd.common.core.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by 1 on 2018/7/18.
 */
public class ImageOploadAndDownloadUtils {

    private static final Logger log = LoggerFactory.getLogger(ImageOploadAndDownloadUtils.class);

    /**
     * 图片上传
     *
     * @param files
     * @return
     * @throws Exception
     */
    public static Map<String, String> executeUpload(MultipartFile[] files, String path) throws IOException {
        if (files.length == 0 || null == files) {
            throw new NullPointerException("没有文件");
        }
        Map<String, String> imageMap = new HashMap<>();
        for (int i = 0; i < files.length; i++) {
            // 拿到文件名
            String keyName = files[i].getName();
            String suffix = files[i].getOriginalFilename().substring(files[i].getOriginalFilename().lastIndexOf("."));
            //避免文件名重复或者中文文件名，使用UUID随机生成新的文件名
            String fileName = UUID.randomUUID().toString().replaceAll("-", "") + suffix;
            //服务器文件对象
            File f = new File(path + fileName);
            //如果没有文件夹，就创建
            if (!f.getParentFile().exists()) {
                f.getParentFile().mkdir();
            }
            files[i].transferTo(f);
            imageMap.put(keyName, fileName);
        }
        return imageMap;
    }

    public static String executeUpload(MultipartFile file, String path) throws Exception {
        if ( null == file) {
            throw new ErrorInfo("没有文件",500);
        }
            // 拿到文件名
            String keyName = file.getName();
            String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
            //避免文件名重复或者中文文件名，使用UUID随机生成新的文件名
            String fileName = UUID.randomUUID().toString().replaceAll("-", "") + suffix;
            //服务器文件对象
            File f = new File(path + fileName);
            //如果没有文件夹，就创建
            if (!f.getParentFile().exists()) {
                f.getParentFile().mkdir();
            }
            file.transferTo(f);
        return fileName;
    }


    /**
     * 图片下载
     *
     * @param imageName
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    public static String downloadImage(String imageName, HttpServletRequest request, HttpServletResponse response, String path) throws IOException {
        log.info("the imageName is:" + imageName);
        //拿到文件名及全路径
        String fileUrl = path + imageName;
        if (null != fileUrl) {
            File file = new File(fileUrl);
            if (file.exists()) {
                // 设置强制下载不打开
                response.setContentType("application/force-download");
                // 设置文件名
                response.addHeader("Content-Disposition", "attachment;fileName=" + imageName);
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream outputStream = response.getOutputStream();
                    int i = bis.read(buffer);
                    if (i != -1) {
                        outputStream.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    log.info("图片下载完成");
                    return "success";
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (null != bis) {
                        bis.close();
                    }
                    if (null != fis) {
                        fis.close();
                    }
                }


            }
        }
        return null;
    }
}
