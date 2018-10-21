package ru.jevo.service;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import ru.jevo.repository.UserRepository;
import ru.jevo.model.User;

import java.io.IOException;
import java.util.List;

public final class UserDataService extends AbstractDataService {

    private final UserRepository userRepository;


    /**
     * Получаем динамическую реализацию UserRepository
     */
    public UserDataService() throws IOException {
        userRepository = sqlSession.getMapper(UserRepository.class);
    }

    public void insert(User user) {
        userRepository.insert(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findUser(String login, String password) {
        return userRepository.findUser(login, password);
    }

    public void updateUser(User user) {
        userRepository.updateUser(user);
    }

    public void commit(){
        sqlSession.commit();
    }

}
