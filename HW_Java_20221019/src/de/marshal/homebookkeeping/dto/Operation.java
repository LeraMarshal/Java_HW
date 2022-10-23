package de.marshal.homebookkeeping.dto;

import java.util.Date;

public abstract class Operation {
    public long id;
    public Date dateTime;
    public Account account;
    public long amount;     // сумма операции в копейках
}
