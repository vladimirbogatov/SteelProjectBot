package persist.model;

import lombok.Getter;
import lombok.Setter;
import persist.model.counter.Counter;

import java.util.List;

@Getter
@Setter
public class Flat extends BaseEntity {

    //TODO обрабоать ошибку, когда пытаюсь добавить в таблицу уже существующую квартиру
    private int flatNumber;

    private List<Counter> counters;

    public Flat() {
    }

    public Flat(int flatNumber) {
        this.flatNumber = flatNumber;
    }
}
