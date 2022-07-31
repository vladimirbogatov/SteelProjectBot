package dao;

import model.counters.Counter;
import model.Flat;
import org.hibernate.*;
import user.User;
import org.hibernate.query.NativeQuery;

import java.util.List;

public class DaoSQLModel implements DaoModel {

    private static SessionFactory sessionFactory;

    public DaoSQLModel() {
        sessionFactory = HibernateUtil.getFactory();
    }

    @Override
    public int getId(Object o) {
        if (o == null) {
            return -1;
        }
        String sql = null;
        List<Integer> idList = null;
        if (o instanceof User) {
            User user = (User) o;
            sql = String.format("SELECT id FROM %s WHERE chat_id = %d", User.class.getSimpleName(), user.getChat_id());
        } else if (o instanceof Flat) {
            Flat flat = (Flat) o;
            sql = String.format("SELECT id FROM %s WHERE number=%d", Flat.class.getSimpleName(), flat.getNumber());
        } else if (o instanceof Counter) {
            Counter counter = (Counter) o;
            sql = String.format("SELECT id FROM %s WHERE snumber=%d AND flat_number=%d", Counter.class.getSimpleName(), counter.getSnumber(), getId(counter.getFlat()));
        } else return -1;

        synchronized (sessionFactory) {
            Session session = sessionFactory.openSession();
            NativeQuery query = session.createNativeQuery(sql);
            idList = query.list();
            session.close();
        }

        if (idList.size() ==1 ) {
            int result = idList.get(0);
            return  result;
        }
        return -1;
    }

    @Override
    public boolean saveToBase(Object[] o) {
        synchronized (sessionFactory) {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            try {
                for (Object obj : o) {
                    session.persist(obj);
                }
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                System.out.println(e.getStackTrace());
                throw e;
            }
            session.close();
            //TODO обработать exception
        }
        return true;
    }
}
