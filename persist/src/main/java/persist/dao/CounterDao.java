package persist.dao;

import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.*;
import persist.model.counter.Counter;

import java.util.List;


@RegisterBeanMapper(Counter.class)
public interface CounterDao extends AbstractDao {

    default Counter insert(Counter counter) {
        if (counter.isNew()) {
            int id = insertGeneratedId(counter);
            counter.setId(id);
        } else {
            insertWitId(counter);
        }
        return counter;
    }

    @SqlUpdate("INSERT INTO counters (serial_number, counter_type, verification_date, verification_period) " +
            "VALUES (:serialNumber, CAST(:counterType AS counter_type), :verificationDate, :verificationPeriod)")
    @GetGeneratedKeys
    int insertGeneratedId(@BindBean Counter counter);

    @SqlUpdate("INSERT INTO counters (id, serial_number, counter_type, verification_date, verification_period) " +
            "VALUES (:id, :serialNumber, CAST(:counterType AS counter_type), :verificationDate, :verificationPeriod)")
    void insertWitId(@BindBean Counter counter);

    @SqlQuery("SELECT * FROM counters ORDER BY serial_number LIMIT :limit")
    List<Counter> getWithLimit(@Bind("limit") int limit);

    //   http://stackoverflow.com/questions/13223820/postgresql-delete-all-content
    @SqlUpdate("TRUNCATE counters CASCADE")
    @Override
    void clean();

    @SqlBatch("INSERT INTO counters (serial_number, counter_type, verification_date, verification_period) " +
            "VALUES (:serialNumber, CAST(:counterType AS counter_type), :verificationDate, :verificationPeriod)")
    void insertBatch(@BindBean List<Counter> counters, @BatchChunkSize int chunkSize);

    @SqlQuery("SELECT * FROM counters WHERE id = :id")
    Counter getWithId(@Bind("id") Integer id);

    @SqlQuery("SELECT * FROM counters WHERE serial_number = :serialNumber")
    Counter getWithSN(@Bind("serialNumber") long serialNumber);
/*
    @SqlQuery("SELECT * FROM counters WHERE id in (<ids>)")
    public abstract List<Counter> getListWithIds(@BindIn("ids") List<Integer> ids);*/
}
