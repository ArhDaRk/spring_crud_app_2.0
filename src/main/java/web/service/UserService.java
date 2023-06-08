package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    void saveUser(User user);

    void updateUser(User user);

    void removeUserById(Integer id);

    List<User> getAllUsers();

    User getUserById(Integer id);
}
