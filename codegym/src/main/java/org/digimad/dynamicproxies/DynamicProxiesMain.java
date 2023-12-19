package org.digimad.dynamicproxies;

import java.lang.reflect.Proxy;

public class DynamicProxiesMain {

    public static void main(String[] args) {

        // Create the original object
        Man arnold = new Man("Arnold", 30, "Thal", "Austria");

        // Get the class loader from the original object
        ClassLoader arnoldClassLoader = arnold.getClass().getClassLoader();

        // Get all the interfaces that the original object implements
        Class[] interfaces = arnold.getClass().getInterfaces();

        // Create a proxy for our arnold object
        Person proxyArnold = (Person) Proxy.newProxyInstance(arnoldClassLoader, interfaces, new PersonInvocationHandler(arnold));

        // Call one of our original object's methods on the proxy object
        proxyArnold.introduce(arnold.getName());

    }
}
