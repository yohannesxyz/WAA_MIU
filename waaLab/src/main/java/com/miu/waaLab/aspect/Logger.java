package com.miu.waaLab.aspect;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@Entity
public class Logger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;
    private Date date;
    private Date time;
    private String principle = "kira";
    private String operation;

    public Logger() {

    }

    public Logger(Long transactionId, Date date, Date time, String principle, String operation) {
        this.transactionId = transactionId;
        this.date = date;
        this.time = time;
        this.principle = principle;
        this.operation = operation;
    }


}