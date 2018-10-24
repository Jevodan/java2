package ru.jevo.chat.server.service;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.jevo.chat.model.User;
import ru.jevo.chat.server.api.UserService;
import ru.jevo.chat.service.UserDataService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class UserServiceBean implements UserService {

    @Inject
    UserDataService userDAO;

    @Override
    public @Nullable User findByLogin(@Nullable String login) {
        if (!checkLogin(login)) return null;
        return userDAO.findUser(login);
    }

    @Override
    public boolean check(@Nullable final String login, @Nullable final String password) {
        if (checkLogin(login) && checkPassword(password)) {
            final User user = findByLogin(login);
            if (user == null) return false;
            return password.equals(user.getPassword());
        }
        return false;
    }

    @Override
    public boolean registry(@Nullable String login, @Nullable String password) {
        if (checkLogin(login) && checkPassword(password)) {
            if (exists(login)) return false;
            @NotNull final User user = new User();
            user.setLogin(login);
            user.setPassword(password);
            System.out.println(login + password);
            userDAO.insert(user);
            userDAO.commit();
            System.out.println("Добавлен пользователь: " + user.getLogin());
            return true;
        }
        System.out.println("Ошибка");
        return false;
    }

    @Override
    public boolean exists(@Nullable String login) {
        User user = userDAO.findUser(login);
        if (user == null) return false;
        return (user.getLogin().equals(login));
    }

    @Override
    public void changeLogin(String login, @Nullable String newLogin) {
        userDAO.updateUser(login, newLogin);
        userDAO.commit();
    }

    private boolean checkLogin(@Nullable String login) {
        return (login == null || login.isEmpty()) ? false : true;
    }

    private boolean checkPassword(@Nullable String password) {
        return (password == null || password.isEmpty()) ? false : true;
    }

}
