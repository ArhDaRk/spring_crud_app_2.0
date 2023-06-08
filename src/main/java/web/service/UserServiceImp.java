package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;
import web.repository.UserService;

import java.util.List;


@Repository
public class UserServiceImp implements web.service.UserService {

    private final UserService userRepository;

    @Autowired
    public UserServiceImp(UserService userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void saveUser(User user) {
        userRepository.saveUser(user);
    }

    @Override
    public void updateUser(User user) {
        userRepository.updateUser(user);
    }

    @Override
    public void removeUserById(Integer id) {
        userRepository.removeUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.getUserById(id);
    }
}
