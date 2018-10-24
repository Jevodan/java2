package ru.jevo.chat.server.api;

import org.jetbrains.annotations.Nullable;
import ru.jevo.chat.model.User;

public interface UserService {

    @Nullable
    User findByLogin(@Nullable String login);

    boolean check(@Nullable String login, @Nullable String password);

    boolean registry(@Nullable String login, @Nullable String password);

    boolean exists(@Nullable String login);

    void changeLogin(String s, @Nullable String login);

}
