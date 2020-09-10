package com.cmh.workstudy.Cache;

/*
    使用递归找出某目录("D:\data")下的所有子目录以及子文件
*/

import java.util.*;
import java.io.*;

public class JavaFileSearch{
    public static void main(String[] args){
        List<String> paths = new ArrayList<String>();
        paths = getAllFilePaths(new File("D:\\data"),paths);
        for(String path:paths){
            System.out.println(path);
        }
    }

    private static List<String> getAllFilePaths(File filePath,List<String> filePaths){
        File[] files = filePath.listFiles();
        //判断目录内是否还有文件
        if(files == null){
            return filePaths;
        }
        for(File f:files){
            //判断文件是否为目录
            if(f.isDirectory()){
                filePaths.add(f.getPath());
                getAllFilePaths(f,filePaths);
            }else{
                filePaths.add(f.getPath());
            }
        }
        return filePaths;
    }
}