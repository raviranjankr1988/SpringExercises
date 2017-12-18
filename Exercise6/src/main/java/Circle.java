public class Circle implements Shape {

    private Point centre;

    public Point getCentre() {
        return centre;
    }

    public void setCentre(Point centre) {
        this.centre = centre;
    }

    public void draw() {
        System.out.println("Drawing Circle");
        System.out.println("Circle Centre point - (" + centre.getX() + "," + centre.getY() + ")");

    }
}
