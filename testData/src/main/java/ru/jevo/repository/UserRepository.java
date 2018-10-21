package ru.jevo.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import ru.jevo.model.User;

import java.util.List;

public interface UserRepository {

    @Select("SELECT * FROM `user`")
    List<User> findAll();

    @Select("SELECT * FROM `user` WHERE login = #{login} AND password = #{password}")
    User findUser(String login, String password);

    @Update("UPDATE `user`(`login`) SET `login` = #{login} WHERE `id` = #{id}")
    void updateUser(User user);

    @Insert("INSERT INTO `user`(`id`, `login`, `password`) " +
            "VALUES (#{id}, #{login}, #{password})")
    void insert(User user);

}
