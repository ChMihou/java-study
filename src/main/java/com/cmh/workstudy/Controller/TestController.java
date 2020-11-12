package com.cmh.workstudy.Controller;

import com.cmh.workstudy.model.Parameter;
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
import java.util.List;

@Controller
public class TestController {

    private static Logger log = LoggerFactory.getLogger(TestController .class);

    @PostMapping(value = "param")
    public @ResponseBody ResponseEntity<Parameter> testBindingResult(@Valid Parameter parameter,
                                                                        BindingResult bindingResult) {
        log.info("test start");
        if(bindingResult.hasErrors()){
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            fieldErrors.forEach(fieldError -> {
                //日志打印不符合校验的字段名和错误提示
                System.out.println("error field is : {} ,message is : {}"+ fieldError.getField()+fieldError.getDefaultMessage());
            });
            for(int i=0;i<fieldErrors.size();i++){
                //控制台打印不符合校验的字段名和错误提示
                System.out.println("error field is :"+fieldErrors.get(i).getField()+",message is :"+fieldErrors.get(i).getDefaultMessage());
            }
            // pesponsibles.setError_msg(fieldErrors);
            return new ResponseEntity<>(parameter, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(parameter, HttpStatus.OK);
    }

    @RequestMapping("paramer")
    public String param(){
        return "paramer";
    }

    @RequestMapping("addbutton")
    public String addbutton(){
        return "addbutton";
    }
}
