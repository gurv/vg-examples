package ru.gurv.vg.sample.account.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACCOUNT_ID_SEQ")
    @SequenceGenerator(name = "ACCOUNT_ID_SEQ", sequenceName = "ACCOUNT_ID_SEQ", allocationSize = 100)
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
        return "Account{" +
                "id=" + id +
                ", ts=" + ts +
                ", state=" + state +
                '}';
    }
}
