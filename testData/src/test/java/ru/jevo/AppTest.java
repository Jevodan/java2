package ru.jevo;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;
import ru.jevo.model.User;
import ru.jevo.service.UserDataService;

import java.io.IOException;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test
    public void testConnect() throws IOException {

        final UserDataService userDAO = new UserDataService();
        final User user = new User();

        user.setLogin("Leka2");
        user.setPassword("leka2");
        userDAO.insert(user);
        userDAO.commit();


       final List<User> users = userDAO.findAll();
        Assert.assertNotNull(users);
    }
}
