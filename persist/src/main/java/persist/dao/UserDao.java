package persist.dao;


import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.*;
import persist.model.counter.Counter;
import persist.model.user.Role;
import persist.model.user.User;
import persist.model.user.UserRoleReducer;

import java.util.List;

@RegisterBeanMapper(User.class)
public interface UserDao extends AbstractDao {

    default User insert(User user) {
        if (user.isNew()) {
            int id = insertGeneratedId(user);
            user.setId(id);
        } else {
            insertWitId(user);
        }
        return user;
    }

    @SqlUpdate("INSERT INTO users (name, chat_id, enabled, data) " +
            "VALUES (:name, :chatId, :enabled, :registered)")
    @GetGeneratedKeys
    int insertGeneratedId(@BindBean User user);

    @SqlUpdate("INSERT INTO users (id,name,chat_id,enabled,data) " +
            "VALUES (:id, :name, :chatId, :enabled, :registered)")
    void insertWitId(@BindBean User user);

    @SqlQuery("SELECT * FROM users ORDER BY chat_id LIMIT :it")
    List<User> getWithLimit(@Bind("it") int limit);

    //   http://stackoverflow.com/questions/13223820/postgresql-delete-all-content
    @SqlUpdate("TRUNCATE users CASCADE")
    @Override
    void clean();

    @RegisterBeanMapper(value = User.class, prefix = "u")
    @RegisterBeanMapper(value = Role.class, prefix = "r")
    @SqlQuery("SELECT u, r FROM " +
            "users u LEFT JOIN user_roles r ON r.user_id = u.id WHERE " +
            "u.id = :id")
    User getById(@Bind("id") int id);

}
