package com.dcmd.common.core.utils;

import com.dcmd.common.core.enums.DeamndConstants;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringPulationUtils {
    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(com.dcmd.common.core.utils.StringPulationUtils.class);

    /**
     * 读取文件转换为字符串
     *
     * @param filePath 文件路径
     * @param fileName 文件名称
     * @return
     */
    public static String file2String(String filePath, String fileName,List<String> str) throws Exception {
        String newStr = null;
        String substring1 = null;
        String substring2 = null;
        String replace2 = null;
        // 拿到指定目录下面的文件
        File file = new File(filePath + fileName);
        FileInputStream inputStream = new FileInputStream(file);
        // 拿到文件大小
        int size = inputStream.available();
        byte[] bytes = new byte[size];
        // 读取
        inputStream.read(bytes);
        inputStream.close();
        // 拿到读取后的字符串
        String oldStr = new String(bytes, "UTF-8");
        // 删除原文件
        file.delete();
        if (!CollectionUtils.isEmpty(str)&& oldStr.contains(DeamndConstants.IMAGES_STYLE)) {
            for (int i = 1; i <= str.size(); i++) {
                // 如果字符串中只有一个图片链接，则替换一次，若有多个，则拿到每次替换后的字符串再次进行替换
                if (i == 1) {
                    newStr = replaceString(oldStr, DeamndConstants.IMAGES + str.get(i - 1), DeamndConstants.MEDIAD_IMAGES + i +replaceImage(oldStr,str.get(i-1)));
                    //截取图片的宽度
                    substring1 = newStr.substring(newStr.indexOf(DeamndConstants.IMAGES_STYLE), newStr.indexOf(DeamndConstants.IMAGES_IN)+3);
                    replace2 = newStr.replace(substring1, "");
                } else if (i >= 2) {
                    newStr = replaceString(replace2, DeamndConstants.IMAGES + str.get(i - 1), DeamndConstants.MEDIAD_IMAGES + i +replaceImage(replace2,str.get(i)));
                    //截取图片的宽度
                    substring2 = newStr.substring(newStr.indexOf(DeamndConstants.IMAGES_WIDTH), newStr.indexOf(DeamndConstants.IMAGES_IN) + 4);
                    replace2 = newStr.replace(substring2, "");
                }
            }
            return replace2;
        }else if (!CollectionUtils.isEmpty(str)){
            for (int i = 1; i <= str.size(); i++) {
                // 如果字符串中只有一个图片链接，则替换一次，若有多个，则拿到每次替换后的字符串再次进行替换
                if (i == 1) {
                    newStr = replaceString(oldStr, DeamndConstants.IMAGES + str.get(i - 1), DeamndConstants.MEDIAD_IMAGES + i +replaceImage(oldStr,str.get(i-1)));
                    //截取图片的宽度
                    substring1 = newStr.substring(newStr.indexOf(DeamndConstants.IMAGES_WIDTH), newStr.indexOf(DeamndConstants.IMAGES_IN+"}")+ 4);
                    replace2 = newStr.replace(substring1, "");
                } else if (i >= 2) {
                    newStr = replaceString(replace2, DeamndConstants.IMAGES + str.get(i - 1), DeamndConstants.MEDIAD_IMAGES + i +replaceImage(replace2,str.get(i-1)));
                    //截取图片的宽度
                    substring2 = newStr.substring(newStr.indexOf(DeamndConstants.IMAGES_WIDTH), newStr.indexOf(DeamndConstants.IMAGES_IN+"}") + 4);
                    replace2 = newStr.replace(substring2, "");
                }
            }
            return replace2;
        }
        return oldStr;
    }

    /**
     * 替换字符串中的内容
     *
     * @param oldStr     原先字符串
     * @param replaceStr 要替换的字符串
     * @param targetStr  目标字符串
     * @return
     */
    public static String replaceString(String oldStr, String replaceStr, String targetStr) {
        if (oldStr.contains(".png") || oldStr.contains(".jpg") || oldStr.contains(".jpf") || oldStr.contains(".jpeg") || oldStr.contains(".emf")) {
            return oldStr.substring(0, oldStr.indexOf(targetStr)) + replaceStr + oldStr.substring(oldStr.indexOf(targetStr) + targetStr.length());
        }
        return oldStr;
    }

    public static String replaceImage(String newStr,String stringName) {
        Pattern pattern = Pattern.compile("/media/(?!(\\.png|\\.jpg|\\.jpf|\\.jpeg|\\.emf)).+?(\\.png|\\.jpg|\\.jpf|\\.jpeg|\\.emf)");
        Matcher matcher = pattern.matcher(newStr);
        String substring = stringName.substring(stringName.indexOf("."));
        while (matcher.find()) {
            if (matcher.group().contains(substring)){
                return substring;
            }
            continue;
        }
        return null;
    }


    public static void run_cmd(String strcmd) throws Exception{
        Runtime rt = Runtime.getRuntime(); //Runtime.getRuntime()返回当前应用程序的Runtime对象
        Process ps = null;  //Process可以控制该子进程的执行或获取该子进程的信息。
        try {
            ps = rt.exec(strcmd);   //该对象的exec()方法指示Java虚拟机创建一个子进程执行指定的可执行程序，并返回与该子进程对应的Process对象实例。
            ps.waitFor();  //等待子进程完成再往下执行。
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        int i = ps.exitValue();  //接收执行完毕的返回值
        if (i == 0) {
            ps.destroy();
            System.out.println("执行完成.");
            System.out.println("00000");
            System.out.println("00000");
            System.out.println("00000");
            System.out.println("00000222112");
            System.out.println("00000222112555");
        } else {
            System.out.println("执行失败.");
        }
//        ps.destroy();  //销毁子进程
        ps = null;
    }


    public static void main(String[] args) throws Exception {
        String line ="<table><tbody><tr class=\"odd\"><td>文档编号：SCR-REM-TMP-006</td><td></td></tr><tr class=\"even\"><td><img src=\"5ab35f1d-94b2-48f6-ac3c-6ee12953f81d人行账户分类标准二期V1.0业务需求说明书（合版）-0818(1)/media/image1.png\" alt=\"四川农信LOGO\" style=\"width:4.5625in;height:0.86458in\" /></td><td></td></tr><tr class=\"odd\"><td><p><strong>四川省农村信用社信息科技中心</strong></p><p><strong>人行账户分类（二期）需求说明书</strong></p></td><td></td></tr><tr class=\"even\"><td><blockquote><p><strong>四川省农村信用社联合社 版权所有，2013</strong></p><p>本文件中包含的任何文字叙述、文档格式、插图、照片、方法、过程等内容，除另有特别注明，版权均属四川省农村信用社联合社所有。未经许可任何人不得将此文件中的任何部分以任何形式进行复制，储存和传播。</p></blockquote></td><td></td></tr><tr class=\"odd\"><td><blockquote><p><strong>文档发布声明</strong></p><p>本【业务需求说明书】自公布之日起在四川省农村信用社联合社信息科技中心内有效。</p></blockquote></td><td></td></tr></tbody></table>\n" +
                "\n" +
                "> **版本记录**\n" +
                "\n" +
                "<table><tbody><tr class=\"odd\"><td><strong>版本号</strong></td><td><strong>发布日期</strong></td><td><strong>编写</strong></td><td><strong>审批</strong></td><td><strong>变更原因</strong></td><td><strong>修订概述</strong></td></tr><tr class=\"even\"><td>0.1.0</td><td></td><td><p>陈玥</p><p>杨杭</p><p>颜静</p></td><td></td><td></td><td>新建</td></tr><tr class=\"odd\"><td></td><td></td><td></td><td></td><td></td><td></td></tr><tr class=\"even\"><td></td><td></td><td></td><td></td><td></td><td></td></tr><tr class=\"odd\"><td></td><td></td><td></td><td></td><td></td><td></td></tr><tr class=\"even\"><td></td><td></td><td></td><td></td><td></td><td></td></tr></tbody></table>\n" +
                "\n" +
                "<table><tbody><tr class=\"odd\"><td><p>[103:pts/25 ] 四川省农村信用社综合业务网络系统C6000 机构码 [2039]</p><p>[203982 :203982 ] [新的通知10| | ] [2010/12/30 11:28:58]</p><p>━━━━━━━━━━━ [ ] ━━━━ [交易码: ]</p><p>交易账户: XXXXXXXXXXXXXXXXX交易金额: XXXXXX</p><p>现转标志 [ ]</p><p>收费编号收费名称收费金额</p><p>━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━</p><p>32 20.00</p><p>━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━</p><p>收费金额合计: 20.00</p></td></tr></tbody></table>\n" +
                "\n" +
                "<table><tbody><tr class=\"odd\"><td>输入域</td><td>类型及长度</td><td>输入属性</td><td>前置条件</td><td>其它要求</td></tr><tr class=\"even\"><td>升降级标志</td><td>9-1 定长</td><td>必输</td><td>无</td><td><ol type=\"1\"><li><p>升级</p></li></ol><p>2-降级</p></td></tr><tr class=\"odd\"><td>升降级类型</td><td>9-1 定长</td><td>必输</td><td>无</td><td><ol type=\"1\"><li><p>III升级I</p></li><li><p>III升级II</p></li><li><p>II升级I</p></li><li><p>I降级II</p></li><li><p>I降级III</p></li><li><p>II降级III</p></li></ol></td></tr><tr class=\"even\"><td>介质状态</td><td>9-1定长</td><td>回显</td><td><p>磁条卡和存折I类账户降级时回显1-保留原介质，不可修改。</p><p>IC卡1类户降级为3类时，回显3-收回原介质，不可修改；降为2类时回显1-配发新介质可修改。</p><p>电子银行的Ⅰ类户降为Ⅱ类时，可选配发新介质或不配发，电子银行的Ⅰ类户降为Ⅲ类时，回显不配发。</p></td><td><p>1-保留原介质</p><p>2-配发新介质</p><p>3-收回原介质</p><p>4-不配发</p></td></tr><tr class=\"odd\"><td>产品码</td><td>9-1定长</td><td>回显</td><td>无</td><td>无</td></tr><tr class=\"even\"><td>磁条标志</td><td>9-1定长</td><td>可输</td><td>无</td><td><p>0-键盘输入</p><p>1 - 磁条读入</p><p>2-读IC卡</p></td></tr><tr class=\"odd\"><td>账/卡 号</td><td>9-25变长</td><td>必输</td><td>无</td><td>无</td></tr><tr class=\"even\"><td>支取方式</td><td>9-8变长</td><td>回显</td><td>根据账号自动判断；电子银行开立的账户未设密码时，此处回显凭密码。</td><td>以掩码方式实现</td></tr><tr class=\"odd\"><td>密码</td><td>9-6定长</td><td>非必输</td><td>无</td><td>无</td></tr><tr class=\"even\"><td>印鉴卡号码</td><td>9-12变长</td><td>非必输</td><td>无</td><td>无</td></tr><tr class=\"odd\"><td>证件类型</td><td>A—1 定长</td><td>必输</td><td>触发联网身份核查</td><td>无</td></tr><tr class=\"even\"><td>证件号码</td><td>*－30变长</td><td>必输</td><td>核查后返显证件号码</td><td>无</td></tr><tr class=\"odd\"><td>存折号码</td><td>9-8定长</td><td>必输</td><td>无</td><td>无</td></tr><tr class=\"even\"><td>磁条标志</td><td>9-1定长</td><td>可输</td><td>保留原介质时，此处不输</td><td><p>0-键盘输入</p><p>1 - 磁条读入</p><p>2-读IC卡</p></td></tr><tr class=\"odd\"><td>新卡卡号</td><td>9-25变长</td><td>回显</td><td>当为新配发介质时读磁后回显</td><td>无</td></tr><tr class=\"even\"><td>密码</td><td>9-6定长</td><td>必输</td><td>8023的产品在此处设置新密码，输入两次。</td><td>无</td></tr><tr class=\"odd\"><td>介质形式</td><td>9-1定长</td><td>回显</td><td>无</td><td><p>0-IC卡</p><p>1-磁条卡</p><p>2-活期存折</p><p>3-无介质</p></td></tr><tr class=\"even\"><td>新产品码</td><td>9-1定长</td><td>可输</td><td>当原产品码为8023时此处的产品码可选，</td><td>IC卡产品码的选项</td></tr><tr class=\"odd\"><td>户名</td><td>*－120变长</td><td>交易成功后回显</td><td>无</td><td>无</td></tr><tr class=\"even\"><td>账户类型</td><td>9-1 定长</td><td>交易成功后回显</td><td>无</td><td><p>1-II类户</p><p>2-Ⅲ类<strong>户</strong></p></td></tr><tr class=\"odd\"><td></td><td></td><td></td><td></td><td><ol type=\"1\"><li></li><li></li><li></li></ol></td></tr><tr class=\"even\"><td>柜员流水号</td><td>9-10 变长</td><td>不可输</td><td>交易成功后回显不可输入。</td><td></td></tr></tbody></table>\n" +
                "\n" +
                "![C:\\\\Users\\\\Administrator\\\\Desktop\\\\通用凭证格式\\\\通用凭证-管理类 (2).jpg](5ab35f1d-94b2-48f6-ac3c-6ee12953f81d人行账户分类标准二期V1.0业务需求说明书（合版）-0818(1)/media/image6.jpeg){width=\"5.760416666666667in\" height=\"3.7708333333333335in\"}\n" +
                "素\n" +
                "\n" +
                "<table><tbody><tr class=\"odd\"><td>输入域</td><td>类型及长度</td><td>输入属性</td><td>前置条件</td><td>其它要求</td></tr><tr class=\"even\"><td>操作标志</td><td>9-1 定长</td><td>必输</td><td>无</td><td><ol type=\"1\"><li><p>查询</p></li></ol><p>2-绑定</p></td></tr><tr class=\"odd\"><td>磁条标志</td><td>9-1定长</td><td>可输</td><td>开户交易联动本交易的此处回显0-键盘输入</td><td><ol type=\"1\"><li><p>键盘输入</p></li></ol><p>1 – 磁条读入</p><p>2-读IC卡</p></td></tr><tr class=\"even\"><td>账/卡 号</td><td>9-25变长</td><td>必输</td><td>无</td><td>无</td></tr><tr class=\"odd\"><td>账户类别</td><td>9-1 定长</td><td>回显</td><td>无</td><td></td></tr><tr class=\"even\"><td>绑定状态</td><td>9-1 定长</td><td>可输</td><td>无</td><td><ol type=\"1\"><li><p>成功</p></li><li><p>失败</p></li><li><p>待对方行验证</p></li><li><p>解绑</p></li></ol></td></tr><tr class=\"odd\"><td>户名</td><td>*－120变长</td><td>回显</td><td>无</td><td>无</td></tr><tr class=\"even\"><td>输入域</td><td>类型及长度</td><td>输入属性</td><td>前置条件</td><td>其它要求</td></tr><tr class=\"odd\"><td>账号</td><td>9-25变长</td><td>回显</td><td>无</td><td>无</td></tr><tr class=\"even\"><td>账户类别</td><td>9-1 定长</td><td>回显</td><td>无</td><td>无</td></tr><tr class=\"odd\"><td>绑定机构</td><td>9-14 变长</td><td>回显</td><td>无</td><td>无</td></tr><tr class=\"even\"><td>状 态</td><td>9-1 定长</td><td>回显</td><td>无</td><td><ol start=\"5\" type=\"1\"><li><p>成功</p></li><li><p>失败</p></li><li><p>待对方行验证</p></li></ol><p>解绑</p></td></tr><tr class=\"odd\"><td>输入域</td><td>类型及长度</td><td>输入属性</td><td>前置条件</td><td>其它要求</td></tr><tr class=\"even\"><td>操作标志</td><td>9-1 定长</td><td>回显</td><td>无</td><td>无</td></tr><tr class=\"odd\"><td>磁条标志</td><td>9-1定长</td><td>可输</td><td>开户交易联动本交易的此处回显0-键盘输入</td><td><ol start=\"2\" type=\"1\"><li><p>键盘输入</p></li></ol><p>1 – 磁条读入</p><p>2-读IC卡</p></td></tr><tr class=\"even\"><td>账/卡 号</td><td>9-60变长</td><td>回显</td><td>无</td><td>无</td></tr><tr class=\"odd\"><td>户名</td><td>*－120变长</td><td>回显</td><td>无</td><td>无</td></tr><tr class=\"even\"><td></td><td></td><td></td><td></td><td></td></tr><tr class=\"odd\"><td></td><td></td><td></td><td></td><td></td></tr><tr class=\"even\"><td>支取方式</td><td>9-8变长</td><td>回显</td><td>无</td><td>以掩码方式实现</td></tr><tr class=\"odd\"><td>密码</td><td>9-6定长</td><td>非必输</td><td>无</td><td>无</td></tr><tr class=\"even\"><td>印鉴卡号码</td><td>9-12变长</td><td>非必输</td><td>无</td><td>无</td></tr><tr class=\"odd\"><td>证件类型</td><td>A—1 定长</td><td>必输</td><td>无</td><td>无</td></tr><tr class=\"even\"><td>证件号码</td><td>*－30变长</td><td>必输</td><td>无</td><td>无</td></tr><tr class=\"odd\"><td>存折号码</td><td>9-8定长</td><td>必输</td><td>无</td><td>无</td></tr><tr class=\"even\"><td>密码</td><td>9-6定长</td><td>必输</td><td>无</td><td>无</td></tr><tr class=\"odd\"><td>绑定账户种类</td><td>9-1定长</td><td>选输</td><td>无</td><td><p>0- 本行Ⅰ类户</p><p>1-本行信用卡户</p><p>2-他行账户</p></td></tr><tr class=\"even\"><td>绑定账户磁条标志</td><td>9-1 定长</td><td>非必输</td><td>无</td><td><p>0-键盘输入</p><p>1 - 磁条读入</p><p>2-读IC卡</p></td></tr><tr class=\"odd\"><td>绑定账户账/卡号</td><td>9-25变长</td><td>选输</td><td>无</td><td>无</td></tr><tr class=\"even\"><td>绑定账户户名</td><td>*－120变长</td><td>选输</td><td>手输</td><td>无</td></tr><tr class=\"odd\"><td>绑定银行行号</td><td>9-14变长</td><td>选输</td><td>绑定他行账户时必输</td><td>当光标到此处时，弹出行号查询界面，根据后续查询结果中所选的行名回显行号。</td></tr><tr class=\"even\"><td></td><td></td><td></td><td></td><td></td></tr><tr class=\"odd\"><td>手机号码</td><td>S—20变长</td><td>选输</td><td>操作标志为绑定时必输</td><td>无</td></tr><tr class=\"even\"><td>是否设置II类户与绑定账户转账限额</td><td>9-1定长</td><td>选输</td><td>当开立Ⅲ类户时，该域不可选为空；</td><td>开立II类户时，默认1-是，可修改0-否</td></tr><tr class=\"odd\"><td>日累计限额</td><td>S-17,2变长</td><td>选输</td><td>选择了是否设置II类户与绑定户转账限额的才能输入本域。该限额为绑定账户向II类账户转入的限额，且日累计限额必须大于0且不能为空；当开立Ⅲ类户时，该域为空。</td><td>无</td></tr><tr class=\"even\"><td></td><td></td><td></td><td></td><td></td></tr><tr class=\"odd\"><td>绑定状态</td><td>9-1 定长</td><td>回显</td><td>无</td><td><ol type=\"1\"><li><p>成功</p></li><li><p>失败</p></li><li><p>待对方行验证</p></li></ol></td></tr><tr class=\"even\"><td>柜员流水号</td><td>9-10变长</td><td>回显</td><td>无</td><td>无</td></tr><tr class=\"odd\"><td><strong>行号查询小界面</strong></td><td></td><td></td><td></td><td></td></tr><tr class=\"even\"><td><strong>输入域</strong></td><td><strong>类型及长度</strong></td><td><strong>输入属性</strong></td><td><strong>前置条件</strong></td><td><strong>其它要求</strong></td></tr><tr class=\"odd\"><td>行别</td><td>9-2定长</td><td>可输</td><td></td><td>下拉菜单。见附件行别列表。</td></tr><tr class=\"even\"><td>省（直辖市）</td><td>*-60 变长</td><td>可输</td><td></td><td>全国各个省和直辖市（支付系统已覆盖的地区）</td></tr><tr class=\"odd\"><td>市</td><td>*-60变长</td><td>可输</td><td></td><td>无</td></tr><tr class=\"even\"><td>行名关键字</td><td>*-60 变长</td><td>可输</td><td></td><td>多个关键字间使用空白键隔开；模糊匹配。在返回的查询结果中使用上下键选中，回车确定所选行名</td></tr><tr class=\"odd\"><td>行号</td><td>9-14 变长</td><td>回显</td><td>无</td><td>无</td></tr><tr class=\"even\"><td>行名</td><td>*-120</td><td>回显</td><td>无</td><td>无</td></tr></tbody></table>\n" +
                "\n" +
                "\n" +
                "<table><tbody><tr class=\"odd\"><td>账户类型</td><td>9-1 定长</td><td>回显</td><td>无</td><td><p>0-未分类</p><p>1-I类户</p><p>2-II类户</p><p>3-Ⅲ类<strong>户</strong></p></td></tr><tr class=\"even\"><td>开立标志</td><td>9-1 定长</td><td>回显</td><td>无</td><td><p>1-面签</p><p>2-未面签</p></td></tr></tbody></table>\n" +
                "\n" +
                "<table><tbody><tr class=\"odd\"><td><strong>输入域</strong></td><td><strong>类型及长度</strong></td><td><strong>输入属性</strong></td><td><strong>前置条件</strong></td><td><strong>其它要求</strong></td></tr><tr class=\"even\"><td>开立标志</td><td>9-1 定长</td><td>回显不可修改</td><td>无</td><td><p>1-面签</p><p>2-未面签</p></td></tr><tr class=\"odd\"><td>账户类型</td><td>9-1 定长</td><td>回显不可修改</td><td>无</td><td><p>0-未分类</p><p>1-I类户</p><p>2-II类户</p><p>3-Ⅲ类<strong>户</strong></p></td></tr><tr class=\"even\"><td>绑定状态</td><td>9-1 定长</td><td>回显不可修改</td><td>无</td><td><ol type=\"1\"><li><p>绑定</p></li><li><p>待绑定</p></li><li><p>无效</p></li><li><p>绑定失败</p></li></ol></td></tr><tr class=\"odd\"><td>原因</td><td>*－120变长</td><td>回显不可修改</td><td>无</td><td>无</td></tr><tr class=\"even\"><td>是否设置II类户与绑定账户转账限额</td><td>S-17,2变长</td><td>回显不可修改</td><td>无</td><td><ol type=\"1\"><li><p>否</p></li><li><p>是</p></li></ol></td></tr><tr class=\"odd\"><td>日累计限额</td><td>S-17,2变长</td><td>回显不可修改</td><td>无</td><td>无</td></tr><tr class=\"even\"><td>与绑定账户日累计限额已达</td><td>S-17,2变长</td><td>回显不可修改</td><td>无</td><td>无</td></tr><tr class=\"odd\"><td>与非绑定账户存款（转入）日累计已达</td><td>S-17,2变长</td><td>回显不可修改</td><td>无</td><td>无</td></tr><tr class=\"even\"><td>与非绑定账户存款（转入）年累计已达</td><td>S-17,2变长</td><td>回显不可修改</td><td>无</td><td>无</td></tr><tr class=\"odd\"><td>与非绑定账户取款（转出）日累计已达</td><td>S-17,2变长</td><td>回显不可修改</td><td>无</td><td>无</td></tr><tr class=\"even\"><td>与非绑定账户取款（转出）年累计已达</td><td>S-17,2变长</td><td>回显不可修改</td><td>无</td><td>无</td></tr></tbody></table>\n" +
                "\n" +
                ">\n" +
                "> ![](5ab35f1d-94b2-48f6-ac3c-6ee12953f81d人行账户分类标准二期V1.0业务需求说明书（合版）-0818(1)/media/image7.png){width=\"6.0in\" height=\"3.8125in\"}\n" +
                ">\n" +
                ">\n" +
                "> ![](5ab35f1d-94b2-48f6-ac3c-6ee12953f81d人行账户分类标准二期V1.0业务需求说明书（合版）-0818(1)/media/image8.png){width=\"6.0in\" height=\"3.5in\"}\n" +
                "\n" +
                ">\n" +
                "> ![](5ab35f1d-94b2-48f6-ac3c-6ee12953f81d人行账户分类标准二期V1.0业务需求说明书（合版）-0818(1)/media/image9.png){width=\"6.0in\" height=\"3.7291666666666665in\"}\n" +
                "\n" +
                "[]{#_Toc486491529 .anchor}![](5ab35f1d-94b2-48f6-ac3c-6ee12953f81d人行账户分类标准二期V1.0业务需求说明书（合版）-0818(1)/media/image10.png){width=\"6.197916666666667in\" height=\"3.7916666666666665in\"}\n" +
                "\n" +
                "\n" +
                "<table><tbody><tr class=\"odd\"><td><strong>序号</strong></td><td><strong>名称</strong></td><td><strong>输入/输出</strong></td><td><strong>缺省值</strong></td>\n" +
                "<td><strong>类型</strong></td><td><strong>是否必输</strong></td><td><strong>备注</strong></td></tr><tr class=\"even\"><td>1</td><td>姓名</td><td>回显/输入</td><td>\n" +
                "</td><td>文本</td><td></td><td>2-3级用户输入，4级及以上用户回显</td></tr><tr class=\"odd\"><td>2</td><td>证件类型</td><td>回显</td><td></td><td>文本</td><td></td>\n" +
                "<td>回显身份证</td></tr><tr class=\"even\"><td>3</td><td>证件号码</td><td>回显</td><td></td><td>文本</td><td></td><td>2-3级用户输入，4级及以上用户回显</td></tr>\n" +
                "<tr class=\"odd\"><td>4</td><td>证件正面照</td><td>输入</td><td></td><td>图片</td><td></td><td>上传图片</td></tr><tr class=\"even\"><td>5</td><td>证件反面照</td><td>输入</td>\n" +
                "<td></td><td>图片</td><td></td><td>上传图片</td></tr><tr class=\"odd\"><td>6</td><td>账户类型</td><td>输入</td><td></td><td>单选按钮</td><td></td><td>II类账户、III类账户，默认为II类账户</td>\n" +
                "</tr><tr class=\"even\"><td>7</td><td>绑定账户账号</td><td>输入</td><td></td><td>文本框/按钮</td><td></td>\n" +
                "<td><p>通过按钮可选择已经下挂的本人本行账户</p><p>非下挂账户或他行账户通过用户输入</p></td></tr><tr class=\"odd\"><td>8</td><td>绑定账户户名</td><td>输入/回显</td><td></td><td></td>\n" +
                "<td></td><td>若是下挂账户回显，非下挂账户输入</td></tr><tr class=\"even\"><td>9</td><td>绑定账户类型</td><td>输入</td><td></td><td>选择框</td><td></td><td><p>四川农信I类账户</p>\n" +
                "<p>四川农信信用卡</p><p>他行账户（系统自动识别）</p></td></tr><tr class=\"odd\"><td>11</td><td>开户银行</td><td>回显/输入</td><td></td><td>文本/选择框</td><td></td>\n" +
                "<td>若是本行账户，自动回显四川省农村信用社、若是他行账户，则让客户进行选择</td></tr><tr class=\"even\"><td>13</td><td>预留手机号码</td><td></td><td></td><td></td><td></td>\n" +
                "<td>绑定账户预留手机号码</td></tr><tr class=\"odd\"><td>14</td><td>短信验证码</td><td></td><td></td><td></td><td></td><td></td></tr><tr class=\"even\"><td>15</td><td>账户协议</td><td></td>\n" +
                "<td></td><td>复选框</td><td></td><td>默认不勾选，需客户勾选</td></tr><tr class=\"odd\"><td>16</td><td>安全认证</td><td></td><td></td><td></td><td></td>\n" +
                "<td>四级及以上<span id=\"_Toc476729194\" class=\"anchor\"></span></td></tr></tbody></table>\n" +
                "\n" +
                "<table><tbody><tr class=\"odd\"><td><strong>序号</strong></td><td><strong>名称</strong></td><td><strong>输入/输出</strong></td><td><strong>缺省值</strong></td><td><strong>类型</strong>\n" +
                "</td><td><strong>是否必输</strong></td><td><strong>备注</strong></td></tr><tr class=\"even\"><td>1</td><td>姓名</td><td>回显</td><td></td><td>文本</td>\n" +
                "<td></td><td></td></tr><tr class=\"odd\"><td>2</td><td>开户银行</td><td>回显</td><td></td><td>文本</td><td></td><td></td></tr>\n" +
                "<tr class=\"even\"><td>3</td><td>账号</td><td>回显</td><td></td><td>文本</td><td></td><td></td></tr><tr class=\"odd\"><td>4</td><td>账户别名</td><td>回显</td><td></td>\n" +
                "<td></td><td></td><td></td></tr><tr class=\"even\"><td>5</td><td>账户别名修改/设置</td><td></td><td></td><td></td><td></td><td><p>若存在则显示修改按钮</p><p>若不存在则显示设置按钮</p>\n" +
                "<p>移动端暂不实现，另外建任务实现此需求</p></td></tr><tr class=\"odd\"><td>6</td><td>余额</td><td>回显</td><td></td><td>文本</td><td></td><td></td></tr><tr class=\"even\"><td>7</td>\n" +
                "<td>明细</td><td>输入</td><td></td><td>按钮</td><td></td><td>链接到账户明细页面</td></tr><tr class=\"odd\"><td>8</td><td>账户类型</td><td>回显</td><td></td><td>文本</td><td></td>\n" +
                "<td>I类、II类、III类</td></tr><tr class=\"even\"><td>9</td><td>降级</td><td>输入</td><td></td><td>文本框/按钮</td><td></td><td>仅I类账户显示</td></tr><tr class=\"odd\"><td>10</td><\n" +
                "td>账户状态</td><td>回显</td><td></td><td>文本</td><td></td><td>与II类账户保持一致</td></tr><tr class=\"even\"><td>11</td><td>账户权限</td><td>回显</td><td></td><td>文本</td><td></td>\n" +
                "<td>回显内容详见业务规则</td></tr><tr class=\"odd\"><td>12</td><td>设置为默认收款账户</td><td>输入</td><td></td><td></td><td></td><td>III类未面签账户不显示此字段</td></tr>\n" +
                "<tr class=\"even\"><td>13</td><td>停用/启用</td><td>输入</td><td></td><td>按钮</td><td></td><td>与无介质II类账户保持一致</td></tr><tr class=\"odd\"><td>15</td><td>绑定账户开户银行</td>\n" +
                "<td>回显</td><td></td><td>文本</td><td></td><td>II、III类账户绑定的I类账户</td></tr><tr class=\"even\"><td>16</td><td>绑定账户账号</td><td>回显</td><td></td><td>文本</td><td></td>\n" +
                "td>II、III类账户绑定的I类账户</td></tr><tr class=\"odd\"><td>17</td><td>修改</td><td>输入</td><td></td><td>按钮</td><td></td>\n" +
                "<td>绑定账户修改，因身份核查或绑定账户校验未通过的III类账户不显示此按钮</td></tr><tr class=\"even\"><td>18</td><td>与绑定账户资金划转日累计限额</td><td>回显</td><td>\n" +
                "</td><td>文本</td><td></td><td>仅II类账户显示</td></tr><tr class=\"odd\"><td>20</td><td>限额修改</td><td>输入</td><td></td><td>按钮</td><td></td><td>仅II类账户显示</td></tr><\n" +
                "tr class=\"even\"><td>21</td><td>解约</td><td>输入</td><td></td><td>按钮</td><td></td><td>因身份核查或绑定账户校验未通过的III类账户不显示此按钮</td></tr></tbody></table>\n" +
                "\n" +
                "![](5ab35f1d-94b2-48f6-ac3c-6ee12953f81d人行账户分类标准二期V1.0业务需求说明书（合版）-0818(1)/media/image11.png){width=\"5.072916666666667in\" height=\"5.489583333333333in\"}\n" +
                "\n" +
                "图一：正常III类账户\n" +
                "\n" +
                "![](5ab35f1d-94b2-48f6-ac3c-6ee12953f81d人行账户分类标准二期V1.0业务需求说明书（合版）-0818(1)/media/image12.png){width=\"5.291666666666667in\" height=\"5.260416666666667in\"}\n" +
                "\n" +
                "图二：III类账户未通过身份核查\n" +
                "\n" +
                "![](5ab35f1d-94b2-48f6-ac3c-6ee12953f81d人行账户分类标准二期V1.0业务需求说明书（合版）-0818(1)/media/image13.png){width=\"5.041666666666667in\" height=\"5.03125in\"}\n" +
                "\n" +
                "图三：III类账户待身份核查\n" +
                "\n" +
                "![](5ab35f1d-94b2-48f6-ac3c-6ee12953f81d人行账户分类标准二期V1.0业务需求说明书（合版）-0818(1)/media/image14.png){width=\"5.114583333333333in\" height=\"4.03125in\"}\n" +
                "\n" +
                "图四：III类账户绑定账户未通过核验\n" +
                "\n" +
                "![](5ab35f1d-94b2-48f6-ac3c-6ee12953f81d人行账户分类标准二期V1.0业务需求说明书（合版）-0818(1)/media/image15.png){width=\"5.0in\" height=\"3.9895833333333335in\"}\n" +
                "\n" +
                "\n" +
                "![](5ab35f1d-94b2-48f6-ac3c-6ee12953f81d人行账户分类标准二期V1.0业务需求说明书（合版）-0818(1)/media/image16.emf)\n" +
                "\n" +
                "\n" +
                "见下图\n" +
                "\n" +
                "![](5ab35f1d-94b2-48f6-ac3c-6ee12953f81d人行账户分类标准二期V1.0业务需求说明书（合版）-0818(1)/media/image17.png){width=\"5.541666666666667in\" height=\"4.03125in\"}\n" +
                "\n" +
                "![](5ab35f1d-94b2-48f6-ac3c-6ee12953f81d人行账户分类标准二期V1.0业务需求说明书（合版）-0818(1)/media/image18.png){width=\"5.447916666666667in\" height=\"4.0625in\"}\n" +
                "\n" +
                "[]{#_Toc486491561 .anchor}![](5ab35f1d-94b2-48f6-ac3c-6ee12953f81d人行账户分类标准二期V1.0业务需求说明书（合版）-0818(1)/media/image19.png){width=\"5.729166666666667in\" height=\"4.333333333333333in\"}\n" +
                "\n";
        Pattern pattern = Pattern.compile("/media/(?!(\\.png|\\.jpg|\\.jpf|\\.jpeg|\\.emf)).+?(\\.png|\\.jpg|\\.jpf|\\.jpeg|\\.emf)");
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }

        String strcmd = "cmd /c start d:\\bstmp\\test.bat";
        run_cmd(strcmd);
        System.out.println("1111");

//        String name="122451531.png";
//        String string = replaceImage(line,name);
//        System.out.println("===:"+string);
    }



    /**
     * 移动指定目录下的文件到目标目录下
     *
     * @param oldPath 移动目录
     * @param newPth  目标路径
     */
    public static synchronized List<String> moveTotherFolders(String oldPath, String newPth) {
        List<String> fileNameList = new ArrayList<>();
        //获取临时图片文件夹
        File startFile = new File(oldPath);
        if (startFile.isFile()) {
            String suffix = startFile.getName().substring(startFile.getName().lastIndexOf("."));
            String fileName = UUID.randomUUID().toString().replaceAll("-", "") + suffix;
            fileNameList.add(fileName);
            boolean b = startFile.renameTo(new File(newPth + fileName));
        } else if (startFile.isDirectory()) {
            File[] files = startFile.listFiles();
            // 拿到要存放图片的目标路径
            String finalNewPth = newPth;
            if (files != null && files.length > 0) {
                Arrays.stream(files).forEach(a -> {
                    String suffix = a.getName().substring(a.getName().lastIndexOf("."));
                    String fileName = UUID.randomUUID().toString().replaceAll("-", "") + suffix;
                    fileNameList.add(fileName);
                    a.renameTo(new File(finalNewPth + fileName));
                });
            }
        }
        startFile.delete();
        return fileNameList;
    }


}
