package persist.dao;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;
import persist.model.counter.Counter;
import persist.model.counter.CounterType;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CounterMapper implements RowMapper<Counter> {
    @Override
    public Counter map(ResultSet rs, StatementContext ctx) throws SQLException {
        return new Counter(rs.getInt("id"), rs.getLong("serial_number"),
                CounterType.valueOf(rs.getString("counter_type")),
                rs.getDate("verification_date").toLocalDate(),
                rs.getInt("verification_period"));
    }
}
