package persist;

import com.google.common.collect.ImmutableList;
import persist.dao.CounterDao;
import persist.model.counter.Counter;
import persist.model.counter.CounterType;

import java.time.LocalDate;
import java.util.List;

public class CounterTestData {
    public static Counter HOT_WATER_FLAT1;
    public static Counter COLD_WATER_FLAT1;
    public static Counter HOT_WATER_FLAT2;
    public static Counter COLD_WATER_FLAT2;
    public static Counter HOT_WATER_FLAT3;
    public static Counter COLD_WATER_FLAT3;
    public static List<Counter> FIST4_COUNTERS;

    public static void init() {
        HOT_WATER_FLAT1 = new Counter(1234567L, CounterType.HOT_WATER,
                LocalDate.of(2022,1,12), 5);
        COLD_WATER_FLAT1 = new Counter(1234568L, CounterType.COLD_WATER,
                LocalDate.of(2022,1,12), 5);
        HOT_WATER_FLAT2 = new Counter(1234569L, CounterType.HOT_WATER,
                LocalDate.of(2022,2,12), 5);
        COLD_WATER_FLAT2 = new Counter(1234570L, CounterType.COLD_WATER,
                LocalDate.of(2022,2,12), 5);
        HOT_WATER_FLAT3 = new Counter(1234571L, CounterType.HOT_WATER,
                LocalDate.of(2022,3,12), 5);
        COLD_WATER_FLAT3 = new Counter(1234572L, CounterType.COLD_WATER,
                LocalDate.of(2022,3,12), 5);
        FIST4_COUNTERS = ImmutableList.of(HOT_WATER_FLAT1,COLD_WATER_FLAT1, HOT_WATER_FLAT2, COLD_WATER_FLAT2);
    }

    public static void setUp() {
        CounterDao dao = DBIProvider.getDao(CounterDao.class);
        dao.clean();
        DBIProvider.getDBI().useTransaction((exp)->{
            FIST4_COUNTERS.forEach(dao::insert);
            dao.insert(HOT_WATER_FLAT3);
            dao.insert(COLD_WATER_FLAT3);
        });
    }
}
