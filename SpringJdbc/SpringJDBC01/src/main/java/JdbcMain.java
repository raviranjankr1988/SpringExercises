import com.springexercises.springjdbc.dao.JdbcDaoImpl;
import com.springexercises.springjdbc.model.Circle;

public class JdbcMain {

    public static void main(String[] args) {

        Circle circle = new JdbcDaoImpl().getCircle(1);
        System.out.println(circle.getName());

    }

}
