package persist.model.counter;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import persist.model.BaseEntity;

import java.beans.ConstructorProperties;
import java.time.LocalDate;

@NoArgsConstructor
@Setter
@Getter
public class Counter extends BaseEntity {

    private long serialNumber; // Серийный номер

    private CounterType counterType; //Тип счётчика

    private LocalDate verificationDate; // Дата последней поверки

    private int verificationPeriod; // Межповерочнй период (лет)

    public Counter(long serialNumber, CounterType counterType, LocalDate verificationDate, int verificationPeriod) {
        this(null, serialNumber, counterType, verificationDate, verificationPeriod);
    }

 //   @ConstructorProperties({"id","serial_number", "counter_type", "verification_date", "verification_period"})
    public Counter(Integer id, long serialNumber, CounterType counterType, LocalDate verificationDate, int verificationPeriod) {
        super(id);
        this.serialNumber = serialNumber;
        this.counterType = counterType;
        this.verificationDate = verificationDate;
        this.verificationPeriod = verificationPeriod;
    }
}
