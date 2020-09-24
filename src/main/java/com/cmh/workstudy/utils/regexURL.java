package com.cmh.workstudy.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regexURL {
    public static void main(String[] agrs ){
        String regex = "(https?|http?|ftp|file)://[-A-Za-z0-9+&@#/%?=~_|!:,.;]+[-A-Za-z0-9+&@#/%=~_|]";

        String txt = "hello,what are you doing now,dsadsadasdsadsadsad,http://hello";

        StringBuffer sb = new StringBuffer();
        //编译正则字符串
        Pattern p = Pattern.compile(regex);
        //利用正则去匹配
        Matcher matcher = p.matcher(txt);
        //如果找到了我们正则里要的东西

        System.out.println(matcher.find());
        while (matcher.find()) {
            //保存到sb中，"\r\n"表示找到一个放一行，就是换行
            sb.append(matcher.group() + "\r\n");
        }
        System.out.println(sb.toString());
    }
}
