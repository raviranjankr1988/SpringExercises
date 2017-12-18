import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Triangle implements ApplicationContextAware,BeanNameAware,InitializingBean,DisposableBean{

    private Point pointA;
    private Point pointB;
    private Point pointC;
    private ApplicationContext context;

    public Point getPointA() {
        return pointA;
    }

    public Point getPointB() {
        return pointB;
    }

    public Point getPointC() {
        return pointC;
    }

    public void setPointA(Point pointA) {
        this.pointA = pointA;
    }

    public void setPointB(Point pointB) {
        this.pointB = pointB;
    }

    public void setPointC(Point pointC) {
        this.pointC = pointC;
    }

    public void draw() {
        System.out.println("Point A = " + getPointA().getX() + ";" + getPointA().getY());
        System.out.println("Point B = " + getPointB().getX() + ";" + getPointB().getY());
        System.out.println("Point C = " + getPointC().getX() + ";" + getPointC().getY());
    }

    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        this.context = applicationContext;

    }

    public void setBeanName(String s) {
        System.out.println("Bean name is :" +s);
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("Intializing Bean init method");
    }

    public void destroy() throws Exception {
        System.out.println("destroying Bean ");

    }

    public void myinit() {
        System.out.println("Intializing Bean myinit method");
    }

    public void myCleanup() {
        System.out.println("myCleanup method called");
    }

}
