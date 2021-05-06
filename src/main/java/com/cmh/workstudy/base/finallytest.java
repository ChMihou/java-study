package com.cmh.workstudy.base;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.atomic.AtomicReference;

import static java.lang.System.exit;

public class finallytest {
    public static int testFinally() {
        try {
            exit(0);
            return 1;
        } catch (Exception e) {
            return 0;
        } finally {
            System.out.println("execute finally");
            return 3;
        }
    }

    public static void main(String[] args) throws UnknownHostException {
//        int result = testFinally();
//        System.out.println(result);
//        String initialReference = "initial value referenced";
//
//        AtomicReference<String> atomicStringReference =
//                new AtomicReference<String>(initialReference);
//
//        String newReference = "new value referenced";
//        boolean exchanged = atomicStringReference.compareAndSet(initialReference, newReference);
//        System.out.println("exchanged: " + exchanged);
//        System.out.println("第一次initialReference：" + initialReference);
//        System.out.println("第一次newReference：" + newReference);
//        exchanged = atomicStringReference.compareAndSet(initialReference, newReference);
//        System.out.println("exchanged: " + exchanged);
//        System.out.println("第二次initialReference：" + initialReference);
//        System.out.println("第二次newReference：" + newReference);
        InetAddress ip4 = Inet4Address.getLocalHost();
        System.out.println(ip4.getHostAddress());
    }
}
