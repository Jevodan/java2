package ru.jevo;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;
import ru.jevo.chat.model.User;
import ru.jevo.chat.service.UserDataService;

import java.io.IOException;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void testConnect() throws IOException {

        final UserDataService userDAO = new UserDataService();
        final User user = new User();

        user.setLogin("test");
        user.setPassword("leka2");
        userDAO.updateUser(user.getLogin(), "Alex");
        final User users = userDAO.findUser("Alex");
        Assert.assertNotNull(users);

    }
}
