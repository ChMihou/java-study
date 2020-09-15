package com.cmh.workstudy.model;

//反射类需求model
public class Student {
    public Student() {
        System.out.println("创建了一个Student无参构造实例");
    }
    private String name;

    public Student(String str) {
        System.out.println("调用了有参构造函数");
    }


}