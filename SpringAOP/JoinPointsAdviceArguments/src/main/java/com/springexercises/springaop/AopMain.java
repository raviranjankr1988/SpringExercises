package com.springexercises.springaop;

import com.springexercises.springaop.service.ShapeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopMain {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        ShapeService shapeService = (ShapeService) ctx.getBean("shapeService");
        //shapeService.getCircle().setName("Circle1");
        shapeService.getCircle().setNameandReturn("Circle1");
        System.out.println(shapeService.getCircle().getName());
        System.out.println(shapeService.getTriangle().getName());
    }

}

