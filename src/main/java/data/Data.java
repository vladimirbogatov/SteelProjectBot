package data;

import model.counters.Counter;
import dao.DaoController;
import model.Flat;
import org.hibernate.annotations.CreationTimestamp;
import user.User;

import javax.persistence.*;
import java.util.Date;

/**
 * Это класс для сохранения данных в SQL
 * Когда пользователь вводит данные в бот, эти данные сохраняются в базе SQL
 * Данные сохраняются в формате сущности данного класса
 */
@Entity
public class Data {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int userId;

    private int  flatId;

    private int counterId;

    //TODO не забыть обработать данные, чтобы отбрасывать всё, что после запятой
    private int data; // Данные счётчика

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;



    public Data(User user, Flat flat, Counter counter, int data, DaoController daoController) {
        this.userId = daoController.getId(user);
        this.flatId = daoController.getId(flat);
        this.counterId = daoController.getId(counter);
        this.data = data;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFlatId() {
        return flatId;
    }

    public void setFlatId(int flatId) {
        this.flatId = flatId;
    }

    public int getCounterId() {
        return counterId;
    }

    public void setCounterId(int counterId) {
        this.counterId = counterId;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
