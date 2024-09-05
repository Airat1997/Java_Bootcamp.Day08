package school21.spring.service.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;
import javax.activation.DataSource;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import school21.spring.service.config.ApplicationConfig;
import school21.spring.service.config.TestApplicationConfig;
import school21.spring.service.repositories.UsersRepository;

public class UsersServiceImplTest {

    @Test
    public void signUp() throws SQLException {
        ApplicationContext context = new AnnotationConfigApplicationContext(
                TestApplicationConfig.class);
        UsersService usersService = context.getBean("UsersServiceTest", UsersService.class);
        String temp = usersService.signUp("test");
        assertNotNull(temp);
    }

}
