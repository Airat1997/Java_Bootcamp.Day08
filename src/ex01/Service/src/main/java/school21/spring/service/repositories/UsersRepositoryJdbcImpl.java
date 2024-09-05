package school21.spring.service.repositories;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.sql.DataSource;
import school21.spring.service.models.User;

public class UsersRepositoryJdbcImpl<T> implements UsersRepository {

    DataSource dataSource;

    public UsersRepositoryJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Optional<T> findById(Long id) throws SQLException {
        Statement statement = connect();
        StringBuilder sqlRequest = new StringBuilder("SELECT * FROM users WHERE id = ");
        sqlRequest.append(id);
        ResultSet resultSet = statement.executeQuery(sqlRequest.toString());
        if (resultSet.next()) {
            User user = new User();
            user.setId(resultSet.getLong("id"));
            user.setMail(resultSet.getString("email"));
            return (Optional<T>) Optional.of(user);
        }
        return Optional.empty();
    }

    @Override
    public List<T> findAll() throws SQLException {
        Statement statement = connect();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
        List<T> result = new ArrayList<>();
        while (resultSet.next()) {
            User user = new User();
            user.setId(resultSet.getLong("id"));
            user.setMail(resultSet.getString("email"));
            result.add((T) user);
        }
        return result;
    }

    @Override
    public void save(Object entity) throws SQLException {
        User user = (User) entity;
        Statement statement = connect();
        long id = user.getId();
        String email = user.getMail();
        ResultSet resultSet = statement.executeQuery(
                "INSERT INTO users (id, email) VALUES (" + id + ", '" + email + "');");

    }

    @Override
    public void update(Object entity) throws SQLException {
        User user = (User) entity;
        Statement statement = connect();
        long id = user.getId();
        String email = user.getMail();
        String updateQuery = "UPDATE users SET email = '" + email + "' WHERE id = " + id;
        int resultSet = statement.executeUpdate(updateQuery);
    }

    @Override
    public void delete(Long id) throws SQLException {
        String updateQuery = "DELETE FROM users WHERE id = " + id;
        Statement statement = connect();
        boolean resultSet = statement.execute(updateQuery);
    }

    @Override
    public Optional<T> findByEmail(String email) throws SQLException {
        Statement statement = connect();
        StringBuilder sqlRequest = new StringBuilder("SELECT * FROM users WHERE email = ");
        sqlRequest.append(email);
        ResultSet resultSet = statement.executeQuery(sqlRequest.toString());
        if (resultSet.next()) {
            User user = new User();
            user.setId(resultSet.getLong("id"));
            user.setMail(resultSet.getString("email"));
            return (Optional<T>) Optional.of(user);
        }
        return Optional.empty();
    }

    private Statement connect() throws SQLException {
        Connection connection = dataSource.getConnection();
        return connection.createStatement();
    }

}
