import com.springexercises.springjdbc.dao.JdbcDaoImpl;
import com.springexercises.springjdbc.model.Circle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcMain {

    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
        JdbcDaoImpl dao = context.getBean("jdbcDaoImpl",JdbcDaoImpl.class);

        Circle circle = dao.getCircle(1);
        System.out.println(circle.getName());

    }

}
