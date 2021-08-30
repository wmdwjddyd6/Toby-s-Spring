package ch1;

import ch1.springbook.user.dao.ConnectionMaker;
import ch1.springbook.user.dao.DConnectionMaker;
import ch1.springbook.user.dao.DaoFactory;
import ch1.springbook.user.dao.UserDao;
import ch1.springbook.user.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class UserDaoTest {
    public static void main(String args[]) throws ClassNotFoundException, SQLException {
        ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
        UserDao dao = context.getBean("userDao", UserDao.class);

        User user = new User();
        user.setId("ID1");
        user.setName("김광민");
        user.setPassword("kkm1234");

        dao.add(user);

        System.out.println(user.getId() + " 등록 성공");

        User user2 = dao.get(user.getId());
        System.out.println(user2.getName());
        System.out.println(user2.getPassword());

        System.out.println(user2.getId() + " 조회 성공");
    }
}

