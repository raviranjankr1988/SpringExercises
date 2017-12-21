package com.springexercises.springaop.service;

import com.springexercises.springaop.aspect.Loggable;
import com.springexercises.springaop.model.Circle;
import com.springexercises.springaop.model.Triangle;

public class ShapeService {
    private Circle circle;
    private Triangle triangle;

    public Circle getCircle() {
        return circle;
    }

    @Loggable
    public void setCircle(Circle circle) {
        System.out.println("setCircle  executed in ShapeService");
        this.circle = circle;
    }

    public Triangle getTriangle() {
        return triangle;
    }

    public void setTriangle(Triangle triangle) {
        this.triangle = triangle;
    }
}
