package persist;

import com.google.common.collect.ImmutableList;
import persist.dao.CounterDao;
import persist.dao.UserDao;
import persist.model.user.Role;
import persist.model.user.User;

import java.time.LocalDateTime;
import java.util.List;

public class UserTestData {
    public static User USER1_53;
    public static User USER2_53;
    public static User USER1_54;
    public static User USER1_188;
    public static User USER2_188;
    public static List<User> FIRST3_USERS;

    public static void init() {
        USER1_53 = new User("Михалыч", 530L, true, LocalDateTime.of(2022, 9, 1, 23, 0), Role.USER);
        USER2_53 = new User("ВИ", 531L, true, LocalDateTime.of(2022, 9, 1, 12, 5), Role.USER);
        USER1_54 = new User("МА", 540L, false, LocalDateTime.of(2000, 10, 5, 9, 30), Role.USER);
        USER1_188 = new User("VV", 1880L, true, LocalDateTime.of(2022, 10, 1, 23, 0), Role.USER, Role.ADMIN);
        USER2_188 = new User("TA", 1881L, true, LocalDateTime.of(2022, 8, 4, 14, 6), Role.USER);
        FIRST3_USERS = ImmutableList.of(USER1_53, USER2_53, USER1_54);
    }

    public static void setUp() {
        UserDao dao = DBIProvider.getDao(UserDao.class);
        dao.clean();
        DBIProvider.getDBI().useTransaction((exp) -> {
            FIRST3_USERS.forEach(dao::insert);
            dao.insert(USER1_188);
            dao.insert(USER2_188);
        });
    }

}
