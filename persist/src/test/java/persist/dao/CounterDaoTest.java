package persist.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import persist.CounterTestData;
import persist.model.counter.Counter;

import java.util.List;

import static persist.CounterTestData.FIST4_COUNTERS;
import static persist.CounterTestData.HOT_WATER_FLAT1;


public class CounterDaoTest extends AbstractDaoTest<CounterDao> {


    public CounterDaoTest() {
        super(CounterDao.class);
    }

    @BeforeClass
    public static void init() throws Exception {
        CounterTestData.init();
    }

    @Before
    public void setUp() throws Exception {
        CounterTestData.setUp();
    }

    @Test
    public void getWithLimit() {
        List<Counter> counters = dao.getWithLimit(4);
        Assert.assertEquals(FIST4_COUNTERS, counters);
    }

    @Test
    public void insertBatch() throws Exception {
        dao.clean();
        dao.insertBatch(FIST4_COUNTERS, 3);
        Assert.assertEquals(4, dao.getWithLimit(100).size());
    }

    @Test
    public void getWithSN() {
        Assert.assertEquals(HOT_WATER_FLAT1, dao.getWithSN(1234567L));
    }

    @Test
    public void getWithId() {
        Counter expected = dao.getWithSN(1234567L);
        Assert.assertEquals(expected, dao.getWithId(expected.getId()));
    }

/*    @Test
    public void getListWithIds() {
        List<Integer> ids_expected = new ArrayList<>();
        ids_expected.add(dao.getWithSN(1234567L).getId());
        ids_expected.add(dao.getWithSN(1234568L).getId());
        ids_expected.add(dao.getWithSN(1234569L).getId());
        ids_expected.add(dao.getWithSN(1234570L).getId());
        Assert.assertEquals(FIST4_COUNTERS, dao.getListWithIds(ids_expected));
    }*/
}