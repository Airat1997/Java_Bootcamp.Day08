package school21.spring.service.config;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import school21.spring.service.repositories.UsersRepository;
import school21.spring.service.repositories.UsersRepositoryJdbcImpl;
import school21.spring.service.services.UsersService;
import school21.spring.service.services.UsersServiceImpl;

@Configuration
public class TestApplicationConfig {

    @Bean
    public DataSource dataSourceTest() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:schema.sql")
                .build();
    }

    @Bean
    public UsersRepository usersRepositoryJdbcTest(DataSource dataSourceTest) {
        return new UsersRepositoryJdbcImpl(dataSourceTest);
    }

    @Bean
    public UsersService UsersServiceTest(UsersRepository usersRepositoryJdbcTest) {
        return new UsersServiceImpl(usersRepositoryJdbcTest);
    }
}
