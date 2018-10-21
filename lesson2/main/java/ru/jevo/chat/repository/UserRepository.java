package ru.jevo.chat.repository;

import org.apache.ibatis.annotations.*;
import ru.jevo.chat.model.User;
import java.util.List;

public interface UserRepository {

    @Select("SELECT * FROM `user`")
    List<User> findAll();

    @Select("SELECT * FROM `user` WHERE login = #{login}")
    User findUser(String login);

    @Update("UPDATE `user` SET `login` = #{param2} WHERE login = #{param1}")
    void updateUser(String login, String newLogin);

    @Insert("INSERT INTO `user`(`id`, `login`, `password`) " +
            "VALUES (#{id}, #{login}, #{password})")
    void insert(User user);

}
