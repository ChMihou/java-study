package com.cmh.workstudy.rmi.rmitest;

import com.cmh.workstudy.model.Parameter;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
/**
 * 远程服务对象实现类写在服务端；必须继承UnicastRemoteObject或其子类
 **/
public class HelloImpl extends UnicastRemoteObject implements Hello {

    /**
     *
     */
    private static final long serialVersionUID = 3638546195897885959L;

    public HelloImpl() throws RemoteException {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public String sayHello(Parameter parameter) throws RemoteException {
        System.out.println("this is server, hello:" + parameter.getName());
        return "hello";
    }

}