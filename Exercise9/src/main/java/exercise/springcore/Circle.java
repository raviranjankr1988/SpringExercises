package exercise.springcore;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

@Component //or Repository,service,controller
public class Circle implements Shape {

    private Point centre;

    public Point getCentre() {
        return centre;
    }

    @Resource
    public void setCentre(Point centre) {
        this.centre = centre;
    }

    public void draw() {
        System.out.println("Drawing Circle");
        System.out.println("Circle Centre point - (" + centre.getX() + "," + centre.getY() + ")");

    }

    @PostConstruct
    public void intializeCircle() {
        System.out.println("in intializeCircle");
    }

    @PreDestroy
    public void destroyCircle() {
        System.out.println("in destroyCircle");
    }

}
