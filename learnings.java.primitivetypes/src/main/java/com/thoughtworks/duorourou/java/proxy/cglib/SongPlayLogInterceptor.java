package com.thoughtworks.duorourou.java.proxy.cglib;

import com.thoughtworks.duorourou.java.proxy.annotation.Proxy;
import lombok.extern.log4j.Log4j2;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.time.LocalDate;

@Log4j2
public class SongPlayLogInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        if (method.isAnnotationPresent(Proxy.class)) {
            log.info("{} at {}", method.getName(), LocalDate.now());
        }
        return proxy.invokeSuper(obj, args);
    }
}
