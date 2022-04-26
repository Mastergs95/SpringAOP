package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppContextWrapper {

    private static ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);

    private AppContextWrapper(){}

    public static ApplicationContext getContext(){
        return context;
    }
}
