package com.qdw.springtest.jdkproxytest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: xiaomi
 * @Description: TODO
 * @date: 2020/7/19 下午4:59
 */
public class Test {
    @org.junit.Test
    public void test1(){
        // 类加载器
        ClassLoader classLoader = InterfaceABImpl.class.getClassLoader();
        // 接口类型数组
        Class[] interfaces = InterfaceABImpl.class.getInterfaces();
        // 调用处理器
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("hello");
                return null;
            }
        };
        Object object = Proxy.newProxyInstance(classLoader,interfaces,invocationHandler);
        InterfaceA interfaceA = (InterfaceA) object;
        InterfaceB interfaceB = (InterfaceB) object;
        Object a = interfaceA.printA("a");
        Object b = interfaceB.printB("b");

        InterfaceA interfaceA1 = new InterfaceABImpl();
        InvocationHandler invocationHandler2 = new ABInvocationHandler(interfaceA1);


    }

    class ABInvocationHandler implements InvocationHandler{
        private InterfaceA interfaceA;
        public ABInvocationHandler(InterfaceA interfaceA){
            this.interfaceA = interfaceA;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

            System.out.println("前");
            interfaceA.printA((String) args[0]);
            System.out.println("后");

            return null;
        }

    }
}
