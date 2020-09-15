package com.cmh.workstudy.base;

import com.cmh.workstudy.model.Product;
import com.cmh.workstudy.model.Student;
import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.util.ResourceBundle;

//反射类demo
//反射类学习url：https://www.jianshu.com/p/356e1d7a9d11
public class reflectTest {
    @SneakyThrows
    public static void main(String args[]) throws IllegalAccessException, InstantiationException {

        System.out.println("***********************************************************");
        System.out.println("<--利用反射获取属性 & 赋值-- >");
        // 1. 获取Student类的Class对象
        Class studentClass = Student.class;

        // 2. 通过Class对象创建Student类的对象
        Object mStudent = studentClass.newInstance();

        // 3. 通过Class对象获取Student类的name属性
        Field f = studentClass.getDeclaredField("name");

        // 4. 设置私有访问权限
        f.setAccessible(true);

        // 5. 对新创建的Student对象设置name值
        f.set(mStudent, "Carson_Ho");

        // 6. 获取新创建Student对象的的name属性 & 输出
        System.out.println(f.get(mStudent));
        System.out.println("***********************************************************");
        System.out.println("<-- 利用反射调用构造函数 -->");
                // 1. 获取Student类的Class对象
        Class studentClass1 = Student.class;

        // 2.1 通过Class对象获取Constructor类对象，从而调用无参构造方法
        // 注：构造函数的调用实际上是在newInstance()，而不是在getConstructor()中调用
        Object mObj1 = studentClass1.getConstructor().newInstance();

        // 2.2 通过Class对象获取Constructor类对象（传入参数类型），从而调用有参构造方法
        Object mObj2 = studentClass1.getConstructor(String.class).newInstance("Carson");
        System.out.println("***********************************************************");
        System.out.println("<-- 工厂类优化：操作成本高：每增加一个接口的子类，必须修改工厂类的逻辑\n" +
                "系统复杂性提高：每增加一个接口的子类，都必须向工厂类添加逻辑 -->");
        // 1. 通过调用工厂类的静态方法（反射原理），从而动态创建产品类实例
        // 需传入完整的类名 & 包名
        Product concreteProduct = Factory.getInstance("com.cmh.workstudy.model.ProductA");

        // 2. 调用该产品类对象的方法，从而生产产品
        concreteProduct.show();

        System.out.println("***********************************************************");
        System.out.println("<-- 工厂类优化二：冲突\n" +
                "开发者 无法提前预知 接口中的子类类型 & 完整类名\n" +
                "通过 属性文件的形式（ Properties） 配置所要的子类信息，\n" +
                "在使用时直接读取属性配置文件从而获取子类信息（完整类名） -->");
        ResourceBundle bundle = ResourceBundle.getBundle("Product.properties");
        String Classname = bundle.getString("ProductA");
        System.out.println(Classname);
        Product concreteProduct1 = Factory.getInstance(Classname);
        concreteProduct1.show();
        System.out.println("***********************************************************");
    }
}
