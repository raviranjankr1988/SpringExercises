import com.springexercises.springjdbc.dao.JdbcDaoImpl;
import com.springexercises.springjdbc.model.Circle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcMain {

    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
        JdbcDaoImpl dao = context.getBean("jdbcDaoImpl",JdbcDaoImpl.class);

//        Circle circle = dao.getCircle(1);
//        System.out.println(circle.getName());

        System.out.println(dao.getCircleCount());
        System.out.println(dao.getCircleName(1));
        System.out.println(dao.getCircleForId(1));

        for(Circle cr : dao.getAllCircles()){
            System.out.println("Circle-id : "+ cr.getId() + " Circle-name : " + cr.getName());
        }

        //dao.insertCircle(new Circle(3,"Circle3"));
        //dao.createTriangleTable();
        dao.insertCircleNamedParameter(new Circle(4,"Circle4"));

    }

}
