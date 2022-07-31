package dao;

import org.hibernate.Session;
import user.User;

public class DaoController {

    private DaoModel daoModel;

    public void setDaoModel(DaoModel daoModel) {
        this.daoModel = daoModel;
    }

    public int getId(Object o) {
        if (o == null) {
            return -1;
        }
        return daoModel.getId(o);
    }

    public boolean saveToBase(Object... o) {
        return daoModel.saveToBase(o);
    }



}
