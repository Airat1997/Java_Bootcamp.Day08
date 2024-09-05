package school21.spring.service.services;

import java.sql.SQLException;
import org.springframework.stereotype.Component;

@Component
public interface UsersService {
    String signUp(String email) throws SQLException;
}
