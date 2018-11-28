package com.dcmd.common.core.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * id
 */
public class RandomIdUtil{

    /**
     * 生成随机文件名：当前年月日时分秒+五位随机数
     *
     * @return
     */
  /*  public static String getRandomFileName() {

        SimpleDateFormat simpleDateFormat;

        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date date = new Date();

        String str = simpleDateFormat.format(date);

        Random random = new Random();

        int rannum = (int) (random.nextDouble() * (99999 - 10000 + 1)) + 1000;// 获取5位随机数

        return str+rannum;// 当前时间
    }

    public static void main(String[] args) {

        String fileName = RandomIdUtil.getRandomFileName();

        System.out.println(fileName);//2018-08-0001   QT-2018-08-001
    }*/

    private static int sequence = 0;

    private static int length = 3;

    /**
     * @author s
     * @return
     */
    public static  String getLocalTrmSeqNum() {
        String datetime = new SimpleDateFormat("yyyy").format(new Date());
        String s = Integer.toString(sequence);
        return datetime;
        //return datetime +"-"+addLeftZero(s, length);
    }

    /**
     * 左填0
     * @author
     * @param
     * @param
     * @return
     */
   public static String addLeftZero(String s, int length) {
        // StringBuilder sb=new StringBuilder();
        int old = s.length();
        if (length > old) {
            char[] c = new char[length];
            char[] x = s.toCharArray();
            if (x.length > length) {
                throw new IllegalArgumentException(
                        "Numeric value is larger than intended length: " + s + " LEN " + length);
            }
            int lim = c.length - x.length;
            for (int i = 0; i < lim; i++) {
                c[i] = '0';
            }
            System.arraycopy(x, 0, c, lim, x.length);
            return new String(c);
        }
        return s.substring(0, length);

    }

    public static void main(String[] args) {
        String localTrmSeqNum = RandomIdUtil.getLocalTrmSeqNum();
        String zero = RandomIdUtil.addLeftZero("3", 3);
        System.out.println(zero);
        System.out.println(localTrmSeqNum);
    }

}

