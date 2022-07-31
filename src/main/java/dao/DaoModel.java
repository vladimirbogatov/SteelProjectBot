package dao;

public interface DaoModel {
    int getId(Object o);

    boolean saveToBase(Object[] o);
}
