package web.repository;

import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import java.util.List;

public interface UserRepository {
    @Transactional
    void saveUser(User user);
    @Transactional
    void updateUser(User user);
    @Transactional
    void removeUserById(Integer id);
    @Transactional(readOnly = true)
    List<User> getAllUsers();
    @Transactional(readOnly = true)
    User getUserById(Integer id);
}
