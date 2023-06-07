package web.dao;

import web.model.User;

import java.util.List;

public interface DAO {
    void saveUser(User user);

    void updateUser( User user);

    void removeUserById(int id);

    List<User> getAllUsers();

}
