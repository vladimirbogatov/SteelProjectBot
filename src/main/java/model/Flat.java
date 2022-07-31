package model;

import model.counters.Counter;
import user.User;

import javax.persistence.*;
import java.util.List;

/**
 * Это класс, который будет сохраняться в таблице SQL.
 * Класс квартир. Номер квартиры - уникален для таблицы
 */

@Entity
public class Flat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //TODO обрабоать ошибку, когда пытаюсь добавить в таблицу уже существующую квартиру
    @Column(unique = true)
    private int number; // flat number

    @OneToMany(mappedBy = "flat", fetch = FetchType.LAZY)
    private List<Counter> counters;

    @ManyToMany
    @JoinTable (name="flat_users",
            joinColumns=@JoinColumn (name="flat_id"),
            inverseJoinColumns=@JoinColumn(name="user_id"))
    private List<User> users;

    public Flat(){}

    public Flat (int number){
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<Counter> getCounters() {
        return counters;
    }

    public void setCounters(List<Counter> counters) {
        this.counters = counters;
    }
}
