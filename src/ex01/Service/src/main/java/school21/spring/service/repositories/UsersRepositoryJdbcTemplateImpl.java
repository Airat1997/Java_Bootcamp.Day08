package school21.spring.service.repositories;

import java.util.List;
import java.util.Optional;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import school21.spring.service.models.User;

public class UsersRepositoryJdbcTemplateImpl<T> implements UsersRepository {

    DataSource dataSource;
    private final JdbcTemplate jdbcTemplate;

    public UsersRepositoryJdbcTemplateImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Optional<User> findById(Long id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        return Optional.ofNullable(jdbcTemplate.queryForObject(sql, new Object[]{id},
                (rs, rowNum) -> new User(rs.getLong("id"), rs.getString("email"))));
    }

    @Override
    public List<User> findAll() {
        String sql = "SELECT * FROM users";
        return jdbcTemplate.query(sql,
                (rs, rowNum) -> new User(rs.getLong("id"), rs.getString("email")));
    }


    @Override
    public void save(Object entity) {
        String sql = "INSERT INTO users (id, email) VALUES (?, ?)";
        User user = (User) entity;
        jdbcTemplate.update(sql, user.getId(), user.getMail());
    }

    @Override
    public void update(Object entity) {
        String sql = "UPDATE users SET (id, email) VALUES (?, ?)";
        User user = (User) entity;
        jdbcTemplate.update(sql, user.getId(), user.getMail());
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM users WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public Optional<T> findByEmail(String email) {
        return Optional.empty();
    }
}
