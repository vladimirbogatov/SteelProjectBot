package model.counters;

import model.Flat;

import javax.persistence.*;
import java.util.Date;

/**
 *
 */
@Entity
@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DB_CNTR")
abstract public class Counter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "flat_number")
    private Flat flat;

    private long snumber; // Серийный номер

    @Enumerated (EnumType.STRING)
    private CounterType counter_type; //Тип счётчика

    @Temporal(TemporalType.DATE)
    private Date verification_date; // Дата последней поверки

    private int verification_period; // Межповерочнй период (лет)

    public Counter(){}

    public Counter(Flat flat, long snumber, CounterType counter_type) {
        this.flat = flat;
        this.snumber = snumber;
        this.counter_type = counter_type;
//        this.verification_date = Calendar.getInstance();
//        this.verification_period = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Flat getFlat() {
        return flat;
    }

    public void setFlat(Flat flat) {
        this.flat = flat;
    }

    public long getSnumber() {
        return snumber;
    }

    public void setSnumber(long snumber) {
        this.snumber = snumber;
    }

    public void setCounter_type(CounterType counter_type) {
        this.counter_type = counter_type;
    }

    public CounterType getCounter_type() {
        return counter_type;
    }

    public Date getVerification_date() {
        return verification_date;
    }

    public void setVerification_date(Date verification_date) {
        this.verification_date = verification_date;
    }

    public int getVerification_period() {
        return verification_period;
    }

    public void setVerification_period(int verification_period) {
        this.verification_period = verification_period;
    }
}
