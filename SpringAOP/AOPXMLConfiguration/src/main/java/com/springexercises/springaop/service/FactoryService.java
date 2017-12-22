package com.springexercises.springaop.service;

import com.springexercises.springaop.model.Circle;
import com.springexercises.springaop.model.Triangle;

public class FactoryService {
    public Object getBean(String beanType) {
        if(beanType.equals("ShapeService")){
            return new ShapeService();
        }
        else if(beanType.equals("Circle")){
            return new Circle();
        }
        else if(beanType.equals("Triangle")){
            return new Triangle();
        }
        else return null;
    }
}
