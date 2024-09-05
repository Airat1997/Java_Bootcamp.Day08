package school21.spring.service.services;

import java.sql.SQLException;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import school21.spring.service.models.User;
import school21.spring.service.repositories.UsersRepository;

@Component
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;

    @Autowired
    public UsersServiceImpl(@Qualifier("usersRepositoryJdbc") UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public String signUp(String email) throws SQLException {
        String temporaryPassword = generateTemporaryPassword();
        User newUser = new User(email, temporaryPassword);
        usersRepository.save(newUser);
        return temporaryPassword;
    }

    public String generateTemporaryPassword() {
        return UUID.randomUUID().toString().substring(0, 8);
    }


}
