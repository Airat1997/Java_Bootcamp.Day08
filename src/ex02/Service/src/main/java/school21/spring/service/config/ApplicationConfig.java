package school21.spring.service.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.DriverManager;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import school21.spring.service.repositories.UsersRepository;
import school21.spring.service.repositories.UsersRepositoryJdbcImpl;
import school21.spring.service.repositories.UsersRepositoryJdbcTemplateImpl;
import school21.spring.service.services.UsersService;
import school21.spring.service.services.UsersServiceImpl;

@Configuration
@PropertySource("classpath:db.properties")
public class ApplicationConfig {
    @Autowired
    private Environment env;

    @Bean
    public DataSource dataSourceHikari() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName(env.getProperty("db.driver.name"));
        config.setJdbcUrl(env.getProperty("db.url.jdbc-url"));
        config.setUsername(env.getProperty("db.user"));
        config.setPassword(env.getProperty("db.password"));
        return new HikariDataSource(config);
    }
    @Bean
    public UsersRepository usersRepositoryJdbc(DataSource dataSourceHikari) {
        return new UsersRepositoryJdbcImpl(dataSourceHikari);
    }
    @Bean
    public UsersService usersServiceJdbc(UsersRepository usersRepositoryJdbc) {
        return new UsersServiceImpl(usersRepositoryJdbc);
    }

    @Bean
    public DataSource dataSourceDriverManager() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("db.driver.name"));
        dataSource.setUrl(env.getProperty("db.url.jdbc-url"));
        dataSource.setUsername(env.getProperty("db.user"));
        dataSource.setPassword(env.getProperty("db.password"));
        return dataSource;
    }
    @Bean
    public UsersRepository usersRepositoryJdbcTemplate(DataSource dataSourceDriverManager) {
        return new UsersRepositoryJdbcTemplateImpl(dataSourceDriverManager);
    }
    @Bean
    public UsersService usersServiceJdbcTemplate(UsersRepository usersRepositoryJdbcTemplate) {
        return new UsersServiceImpl(usersRepositoryJdbcTemplate);
    }




}
