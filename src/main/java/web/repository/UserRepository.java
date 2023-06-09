package web.repository;

import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import java.util.List;

public interface UserRepository {

    void saveUser(User user);

    void updateUser(User user);

    void removeUserById(Integer id);

    List<User> getAllUsers();

    User getUserById(Integer id);
}
