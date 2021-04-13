package com.cmh.workstudy.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Person implements Serializable {
    private static final long serialVersionUID = -5277021277766091968L;

    private String name;

    private String age;

    private String number;
}
