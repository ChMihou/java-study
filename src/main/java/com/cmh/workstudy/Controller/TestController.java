package com.cmh.workstudy.Controller;

import com.cmh.workstudy.model.Parameter;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Controller
public class TestController {

    private static Logger log = LoggerFactory.getLogger(TestController.class);

    @PostMapping(value = "param")
    public @ResponseBody
    ResponseEntity<Parameter> testBindingResult(@Valid Parameter parameter,
                                                BindingResult bindingResult) {
        log.info("test start");
        if (bindingResult.hasErrors()) {
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            fieldErrors.forEach(fieldError -> {
                //日志打印不符合校验的字段名和错误提示
                System.out.println("error field is : {} ,message is : {}" + fieldError.getField() + fieldError.getDefaultMessage());
            });
            for (int i = 0; i < fieldErrors.size(); i++) {
                //控制台打印不符合校验的字段名和错误提示
                System.out.println("error field is :" + fieldErrors.get(i).getField() + ",message is :" + fieldErrors.get(i).getDefaultMessage());
            }
            // pesponsibles.setError_msg(fieldErrors);
            return new ResponseEntity<>(parameter, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(parameter, HttpStatus.OK);
    }

    @RequestMapping("paramer")
    public String param() {
        return "paramer";
    }

    @RequestMapping("addbutton")
    public String addbutton() {
        return "addbutton";
    }

    public static void main(String[] args) {

//        SimpleDateFormat sdf = new SimpleDateFormat();
//        sdf.applyPattern("yyyy-MM-dd HH:mm:ss a");
//        Date date = new Date();
//        System.out.println("循环开始时间：" + sdf.format(date));
//        for (int i = 0; i < 1000; i++)
//            System.out.println("循环开始时间：" + sdf.format(date));
        List<String> strings = new ArrayList<>();
        System.out.println(strings.size());
        strings.add("测试SIZE");
        System.out.println(strings.size());

    }

    public static long ip(String ip) {
        if (Strings.isNullOrEmpty(ip)) {
            return 0L;
        }
        String realIp = ip;
        if (realIp.indexOf(',') != -1) {
            Iterator<String> it = Splitter.on(",").omitEmptyStrings().trimResults().split(ip).iterator();
            while (it.hasNext()) {
                realIp = it.next();
            }
        }
        try {
            Iterator<String> it = Splitter.on(".").trimResults().split(realIp).iterator();
            System.out.println(Long.valueOf(Long.parseLong(it.next()) << 24L | Long.parseLong(it.next()) << 16L | Long.parseLong(it.next()) << 8L | Long.parseLong(it.next())));
            return (Long.parseLong(it.next()) << 24) | (Long.parseLong(it.next()) << 16) | (Long.parseLong(it.next()) << 8) | Long.parseLong(it.next());
        } catch (Exception e) {
            log.error("failure to convert ip to int", e);
            return 0L;
        }
    }

    public static String long2IP(long longIp) {
        StringBuffer sb = new StringBuffer("");
        sb.append(String.valueOf(longIp >>> 24L));
        sb.append(".");
        sb.append(String.valueOf((longIp & 0xFFFFFFL) >>> 16L));
        sb.append(".");
        sb.append(String.valueOf((longIp & 0xFFFFL) >>> 8L));
        sb.append(".");
        sb.append(String.valueOf(longIp & 0xFFL));
        return sb.toString();
    }
}
