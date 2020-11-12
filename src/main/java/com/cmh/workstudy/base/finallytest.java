package com.cmh.workstudy.base;

import static java.lang.System.exit;

public class finallytest{
    public static int testFinally(){
        try {
            exit(0);
            return 1;
        } catch (Exception e) {
            return 0;
        }finally{
            System.out.println("execute finally");
            return 3;
        }
    }
    public static void main(String[] args){
        int result = testFinally();
        System.out.println(result);
    }
}
