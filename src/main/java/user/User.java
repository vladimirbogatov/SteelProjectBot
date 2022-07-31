package user;

import model.Flat;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //TODO обработать ошибку, если добавляют пользователя с существующим id
    @Column(unique = true)
    private long chat_id;

    @Enumerated (EnumType.STRING)
    private State state;

    @ManyToMany
    @JoinTable (name="user_flats",
            joinColumns=@JoinColumn (name="user_id"),
            inverseJoinColumns=@JoinColumn(name="flat_id"))
    private List<Flat> flats;

    public User(long chat_id, Flat... flats) {
        this.chat_id = chat_id;
        this.state = State.NEW;
        this.flats = Arrays.asList(flats);
    }

    public int getId() {
        return id;
    }

    public long getChat_id() {
        return chat_id;
    }

    public void setChat_id(long chat_id) {
        this.chat_id = chat_id;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public List<Flat> getFlats() {
        return flats;
    }

    public void setFlats(List<Flat> flats) {
        this.flats = flats;
    }

}
