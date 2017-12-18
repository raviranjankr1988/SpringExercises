import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class DrawingApp {
    public static void main(String[] args) {
        ApplicationContext factory = new ClassPathXmlApplicationContext("spring.xml");
//        Triangle tr = (Triangle) factory.getBean("triangle");
//        tr.draw();

        Shape shape1 = (Shape) factory.getBean("triangle");
        Shape shape2 = (Shape) factory.getBean("circle");
        shape1.draw();
        shape2.draw();


    }
}
