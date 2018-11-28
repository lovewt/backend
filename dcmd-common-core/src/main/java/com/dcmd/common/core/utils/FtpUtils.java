package com.dcmd.common.core.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


//String path = "/home1/ftproot/textftp/test/";  
//File f1 = new File("d:\\a.txt");  
//String filename = f1.getName();  
//System.out.println(filename);  
//ftpTest a = new ftpTest();  
//InputStream input = new FileInputStream(f1);  
//FTPClient ftp = a.getConnectionFTP("111.222.333.444", 21, "testU", "testP");  
////a.deleteFile(ftp, path, "a[2].txt");  
//a.uploadFile(ftp, path, filename, input);  
//a.closeFTP(ftp); 

public class FtpUtils {  
	
	private final static Logger logger = LoggerFactory.getLogger(FtpUtils.class);
	
    /** 
     * 获得连接-FTP方式 
     * @param hostname FTP服务器地址 
     * @param port FTP服务器端口 
     * @param username FTP登录用户名 
     * @param password FTP登录密码 
     * @return FTPClient 
     */  
    public FTPClient getConnectionFTP(String hostName, int port, String userName, String passWord) {  
        //创建FTPClient对象  
        FTPClient ftp = new FTPClient();  
        try {  
            //连接FTP服务器  
            ftp.connect(hostName, port);  
            //下面三行代码必须要，而且不能改变编码格式，否则不能正确下载中文文件  
            ftp.setControlEncoding("GBK");  
            FTPClientConfig conf = new FTPClientConfig(FTPClientConfig.SYST_NT);  
            conf.setServerLanguageCode("zh");  
            //登录ftp  
            ftp.login(userName, passWord);  
            if (!FTPReply.isPositiveCompletion(ftp.getReplyCode())) {  
                ftp.disconnect();  
                logger.info("FtpUtils.getConnectionFTP,连接服务器失败");
            }  
            logger.info("FtpUtils.getConnectionFTP,登陆服务器成功");
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        return ftp;  
    }  
      
    /** 
     * 关闭连接-FTP方式 
     * @param ftp FTPClient对象 
     * @return boolean 
     */  
    public boolean closeFTP(FTPClient ftp) {  
        if (ftp.isConnected()) {  
            try {  
            	ftp.logout();
                ftp.disconnect();  
                logger.info("FtpUtils.getConnectionFTP,ftp已经关闭");
                return true;  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }  
        return false;  
    }  
      
    /** 
     * 上传文件-FTP方式 
     * @param ftp FTPClient对象 
     * @param path FTP服务器上传地址 
     * @param filename 本地文件路径 
     * @param inputStream 输入流 
     * @return boolean 
     */  
    public boolean uploadFile(FTPClient ftp, String path, String fileName, InputStream inputStream) {  
        boolean success = false;  
        try {
        	//创建一层目录
//        	boolean createDir = ftp.makeDirectory(path);
        	//创建多差目录
        	boolean createDir = FtpUtils.mkdirs(ftp, path);
        	
        	if (!createDir) {
				logger.info("FtpUtils.uploadFile,创建目录失败");
			}
        	logger.info("FtpUtils.uploadFile,创建目录成功");
            boolean enterDir = ftp.changeWorkingDirectory(path);//转移到指定FTP服务器目录
            if (!enterDir) {
            	logger.info("FtpUtils.uploadFile,进入目录失败");
			}
            logger.info("FtpUtils.uploadFile,进入目录成功");
            FTPFile[] fs = ftp.listFiles();//得到目录的相应文件列表  
            fileName = FtpUtils.changeName(fileName, fs);  
            fileName = new String(fileName.getBytes("GBK"),"ISO-8859-1");  
            path = new String(path.getBytes("GBK"), "ISO-8859-1");  
            //转到指定上传目录
            ftp.changeWorkingDirectory(path);  
            //将上传文件存储到指定目录
            ftp.setFileType(FTP.BINARY_FILE_TYPE);  
            //如果缺省该句 传输txt正常 但图片和其他格式的文件传输出现乱码  
            success = ftp.storeFile(fileName, inputStream);  
            if (!success) {
            	logger.info("FtpUtils.uploadFile,上传失败");
			}
            //关闭输入流  
            inputStream.close();  
            //退出ftp  
            //ftp.logout();  
            //表示上传成功  
            //success = true;  
            logger.info("FtpUtils.uploadFile,上传成功");
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {
			
		} 
        return success;  
    }  
  
    /** 
     * 删除文件-FTP方式 
     * @param ftp FTPClient对象 
     * @param path FTP服务器上传地址 
     * @param filename FTP服务器上要删除的文件名 
     * @return 
     */  
    public boolean deleteFile(FTPClient ftp, String path, String fileName) {  
        boolean success = false;  
        try {  
            /*boolean enterDir = ftp.changeWorkingDirectory(path);//转移到指定FTP服务器目录  
            if (!enterDir) {
				System.out.println("进入目录失败");
			}
            System.out.println("进入目录成功");*/
            fileName = new String(fileName.getBytes("GBK"), "ISO-8859-1");  
            //path = new String(path.getBytes("GBK"), "ISO-8859-1");  
            success = ftp.deleteFile(fileName);  
            if (!success) {
            	logger.info("FtpUtils.deleteFile,删除失败");
			}
            //ftp.logout();  
            //success = true;  
            logger.info("FtpUtils.deleteFile,删除成功");
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return success;  
    }  
  
    /** 
     * 下载文件-FTP方式 
     * @param ftp FTPClient对象 
     * @param path FTP服务器上传地址 
     * @param fileName 本地文件路径 
     * @param localPath 本里存储路径 
     * @return boolean 
     */  
    public boolean downFile(FTPClient ftp, String path, String fileName, String localPath)
    {  
        boolean success = false;  
        try {  
            boolean enterDir = ftp.changeWorkingDirectory(path);//转移到FTP服务器目录  
            if (!enterDir) {
				logger.info("FtpUtils.downFile,进入目录失败");
			}
            logger.info("FtpUtils.downFile,进入目录成功");
            FTPFile[] fs = ftp.listFiles(); //得到目录的相应文件列表  
            for (FTPFile ff : fs) {  
                if (ff.getName().equals(fileName)) {  
                    File localFile = new File(localPath + "\\" + ff.getName());  
                    OutputStream outputStream = new FileOutputStream(localFile);  
                    //将文件保存到输出流outputStream中  
                    success = ftp.retrieveFile(new String(ff.getName().getBytes("GBK"), "ISO-8859-1"), outputStream);
                    if (!success) {
                    	logger.info("FtpUtils.downFile,下载失败");
        			}
                    outputStream.flush();  
                    outputStream.close();  
                }  
            }  
            //ftp.logout();  
            //success = true;  
            logger.info("FtpUtils.downFile,下载成功");
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return success;  
    }  
      
    /** 
     * 判断是否有重名文件 
     * @param fileName 
     * @param fs 
     * @return 
     */  
    public static boolean isFileExist(String fileName, FTPFile[] fs) {  
        for (int i = 0; i < fs.length; i++) {  
            FTPFile ff = fs[i];  
            if (ff.getName().equals(fileName)) {  
                return true; //如果存在返回 正确信号  
            }  
        }  
        return false; //如果不存在返回错误信号  
    }  
  
    /** 
     * 根据重名判断的结果 生成新的文件的名称 
     * @param fileName 
     * @param fs 
     * @return 
     */  
    public static String changeName(String fileName, FTPFile[] fs) {  
        int n = 0;  
//      fileName = fileName.append(fileName);  
        while (isFileExist(fileName.toString(), fs)) {  
            n++;  
            String a = "[" + n + "]";  
            int b = fileName.lastIndexOf(".");//最后一出现小数点的位置  
            int c = fileName.lastIndexOf("[");//最后一次"["出现的位置  
            if (c < 0) {  
                c = b;  
            }  
            StringBuffer name = new StringBuffer(fileName.substring(0, c));//文件的名字  
            StringBuffer suffix = new StringBuffer(fileName.substring(b + 1));//后缀的名称  
            fileName = name.append(a) + "." + suffix;  
        }  
        return fileName.toString();  
    }  
    
    /**
     * 循环创建多层目录
     * @param ftp	
     * @param paths	多层目录路径  使用yyyy/MM/dd
     * @return
     */
    public static boolean mkdirs(FTPClient ftp,String path){
    	boolean flag = false;
		try {
			String[] arrayPath = path.split("/");
			for (int i = 0; i < arrayPath.length; i++) {
				//判断是否存在目录 true存在 false不存在
				boolean cwdFlag = ftp.changeWorkingDirectory(arrayPath[i]);
				if (!cwdFlag) {
					//不存在就创建目录
					flag = ftp.makeDirectory(arrayPath[i]);
					//转移到指定FTP服务器目录
					ftp.changeWorkingDirectory(arrayPath[i]);
				} else {
					flag = true;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
    	return flag;
    }
  
}