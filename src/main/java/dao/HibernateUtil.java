package dao;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory factory;
    static {
        try {
            factory = new Configuration()
                    .configure()
                    .buildSessionFactory();
        } catch (HibernateException e) {
            //TODO обработать ошибку получения сессии
            throw e;
        }
    }

    public static SessionFactory getFactory (){
        return factory;
    }
}
