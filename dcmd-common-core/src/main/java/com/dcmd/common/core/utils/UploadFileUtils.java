package com.dcmd.common.core.utils;

import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.*;

public class UploadFileUtils {
    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(com.dcmd.common.core.utils.UploadFileUtils.class);

    /**
     * word格式转换
     * @param commandStr 转换命令
     * @param path  目录
     * @return 转换名称
     * @throws IOException
     */
    public static String uploadTemplate(String commandStr, String path) throws IOException, InterruptedException {
        ProcessBuilder processBuilder = new ProcessBuilder("/bin/sh", "-c", commandStr);
        processBuilder.directory(new File(path));
        Process process = processBuilder.start();
        return null;
    }

    /***
     * 获取文件mingc
     * @param path
     * @return
     * @throws IOException
     */
    public static String fileTemplateName(String path) throws IOException {
        //拿到目录下文件
        //获取file所有的文件和文件夹对象
        File file = new File(path);
        File[] files = file.listFiles();
        for (File subFile : files) {
            if (subFile.isFile() && subFile.getName().endsWith(".md")) {
                String name = subFile.getName();
                return name;
            }
        }
        file.delete();
        return null;
    }


}



