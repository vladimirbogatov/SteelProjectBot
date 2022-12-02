package persist.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import persist.UserTestData;
import persist.model.user.User;

import java.util.List;

import static persist.UserTestData.*;

public class UserDaoTest extends AbstractDaoTest<UserDao> {

    public UserDaoTest() {
        super(UserDao.class);
    }

    @BeforeClass
    public static void init() throws Exception {
        UserTestData.init();
    }

    @Before
    public void setUp() throws Exception {
        UserTestData.setUp();
    }

    @Test
    public void getWithLimit() {
        List<User> users = dao.getWithLimit(3);
        Assert.assertEquals(FIRST3_USERS, users);
    }

    @Test
    public void getById() {
        User actual = dao.getById(USER1_188.getId());
        Assert.assertEquals(USER1_188, actual);
    }
}
