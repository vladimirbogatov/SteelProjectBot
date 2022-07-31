package model.counters;

import model.Flat;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("WTR_CNTR")
public class Water_Counter extends Counter {
    public Water_Counter() {
    }

    public Water_Counter(Flat flat, long snumber, CounterType counter_type) {
        super(flat, snumber, counter_type);
    }

}
