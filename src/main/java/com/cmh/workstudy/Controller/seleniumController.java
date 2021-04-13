package com.cmh.workstudy.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class seleniumController {

    @RequestMapping("")
    public ModelAndView test(ModelAndView mv) {
        mv.setViewName("/first");
        return mv;
    }

    @RequestMapping("/firstform")
    public ModelAndView firstForm(String lastname, String name, String email, ModelAndView mv) {
        System.out.println("名字:" + lastname + "姓氏：" + lastname + "邮箱：" + email);
        mv.setViewName("/second");
        return mv;
    }

    @RequestMapping("/secondform")
    public String secondForm(String postcode,String state){
        return "/ok";
    }
}
