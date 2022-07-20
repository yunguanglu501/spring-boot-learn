package com.example.learn.ioc;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

public class ProgrammerTest {

    public static void main(String[] args) {
        // new Programmer().showMaterial();

        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(Programmer.class);
        beanDefinitionBuilder.addPropertyValue("name", "mghio");
        beanDefinitionBuilder.addPropertyValue("age", 18);
        beanDefinitionBuilder.addPropertyValue("hasGirlFriend", false);

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.registerBeanDefinition("programmer", beanDefinitionBuilder.getBeanDefinition());

        Programmer programmer = (Programmer) beanFactory.getBean("programmer");
        programmer.showMaterial();
    }

}
