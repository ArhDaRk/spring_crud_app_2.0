package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;
import web.repository.UserRepository;

import java.util.List;


@Service
public class UserServiceImp implements web.service.UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Transactional
    @Override
    public void saveUser(User user) {
        userRepository.saveUser(user);
    }
    @Transactional
    @Override
    public void updateUser(User user) {
        userRepository.updateUser(user);
    }
    @Transactional
    @Override
    public void removeUserById(Integer id) {
        userRepository.removeUserById(id);
    }
    @Transactional(readOnly = true)
    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }
    @Transactional(readOnly = true)
    @Override
    public User getUserById(Integer id) {
        return userRepository.getUserById(id);
    }
}
