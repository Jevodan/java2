package ru.jevo.chat.service;


import org.apache.ibatis.annotations.Update;
import ru.jevo.chat.model.User;
import ru.jevo.chat.repository.UserRepository;

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

    public User findUser(String login) {
        return userRepository.findUser(login);
    }

    public void updateUser(String login, String newLogin) {
        userRepository.updateUser(login, newLogin);
    }

    public void commit() {
        sqlSession.commit();
    }

}
