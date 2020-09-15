//package com.cmh.workstudy.base;
//
//public class JavaReflect {
//
//    public static void main(String args[]) {
//        // 即以下方法都分别属于`Constructor`类、`Method`类 & `Field`类的方法。
//
////    <-- 1. 通过Constructor 类对象获取类构造函数信息 -->
//        String getName();// 获取构造器名
//        Class getDeclaringClass();// 获取一个用于描述类中定义的构造器的Class对象
//        int getModifiers ();// 返回整型数值，用不同的位开关描述访问修饰符的使用状况
//        Class[] getExceptionTypes ();// 获取描述方法抛出的异常类型的Class对象数组
//        Class[] getParameterTypes ();// 获取一个用于描述参数类型的Class对象数组
//
//      <--2. 通过Field类对象获取类属性信息-- >
//        String getName();// 返回属性的名称
//        Class getDeclaringClass (); // 获取属性类型的Class类型对象
//        Class getType ();// 获取属性类型的Class类型对象
//        int getModifiers (); // 返回整型数值，用不同的位开关描述访问修饰符的使用状况
//        Object get(Object obj);// 返回指定对象上 此属性的值
//        void set(Object obj, Object value) // 设置 指定对象上此属性的值为value
//
////        <--3. 通过Method 类对象获取类方法信息 -- >
//                String getName();// 获取方法名
//        Class getDeclaringClass ();// 获取方法的Class对象
//        int getModifiers ();// 返回整型数值，用不同的位开关描述访问修饰符的使用状况
//        Class[] getExceptionTypes ();// 获取用于描述方法抛出的异常类型的Class对象数组
//        Class[] getParameterTypes ();// 获取一个用于描述参数类型的Class对象数组
//
////<--额外：java.lang.reflect.Modifier类-- >
//// 作用：获取访问修饰符
//
//        static String toString ( int modifiers)
//// 获取对应modifiers位设置的修饰符的字符串表示
//
//        static boolean isXXX ( int modifiers)
//// 检测方法名中对应的修饰符在modifiers中的值
//    }
//}
