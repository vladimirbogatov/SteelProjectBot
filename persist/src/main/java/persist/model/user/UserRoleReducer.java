package persist.model.user;

import org.jdbi.v3.core.config.ConfigRegistry;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.result.LinkedHashMapRowReducer;
import org.jdbi.v3.core.result.RowView;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Map;

//https://stackoverflow.com/questions/24337100/how-to-create-a-one-to-many-relationship-with-jdbi-sql-object-api
public class UserRoleReducer implements LinkedHashMapRowReducer<Integer, User> {
    @Override
    public void accumulate(Map<Integer, User> container, RowView rowView) {
        final User user = container.computeIfAbsent(rowView.getColumn("u_id", Integer.class),
                id -> rowView.getRow(User.class));
        if (rowView.getColumn("r_id", Integer.class) != null) {
            user.addRole(rowView.getRow(Role.class));
        }
    }
}
