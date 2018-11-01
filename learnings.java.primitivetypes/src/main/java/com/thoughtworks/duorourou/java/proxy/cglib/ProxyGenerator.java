package com.thoughtworks.duorourou.java.proxy.cglib;

import lombok.extern.log4j.Log4j2;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.CallbackFilter;
import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.Method;

@Log4j2
public class ProxyGenerator {

    public <T> T build(Class<T> clazz) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallbacks(new Callback[]{new SongPlayerCallback(), new SongPlayLogInterceptor()});
        enhancer.setCallbackFilter(new CallbackFilter() {
            @Override
            public int accept(Method method) {
                return 0;
            }
        });
        return (T) enhancer.create();
    }


}
