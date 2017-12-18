import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

public class Circle implements Shape {

    private Point centre;

    public Point getCentre() {
        return centre;
    }

    @Resource(name = "point2")
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
