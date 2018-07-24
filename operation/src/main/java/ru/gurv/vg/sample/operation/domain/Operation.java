package ru.gurv.vg.sample.operation.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Operation {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OPERATION_ID_SEQ")
    @SequenceGenerator(name = "OPERATION_ID_SEQ", sequenceName = "OPERATION_ID_SEQ", allocationSize = 100)
	private long id;

    @Column(updatable = false)
	private LocalDateTime ts;

    @Column(insertable = false)
    private Integer state;

    public void setTs(LocalDateTime ts) {
        this.ts = ts;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "id=" + id +
                ", ts=" + ts +
                ", state=" + state +
                '}';
    }
}
