import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;

public class Circle implements Shape {

    private Point centre;

    public Point getCentre() {
        return centre;
    }

//    @Required

    @Qualifier("circleRelatedBean")
    @Autowired
    public void setCentre(Point centre) {
        this.centre = centre;
    }

    public void draw() {
        System.out.println("Drawing Circle");
        System.out.println("Circle Centre point - (" + centre.getX() + "," + centre.getY() + ")");

    }
}
