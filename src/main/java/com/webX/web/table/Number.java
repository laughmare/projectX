package com.webX.web.table;
// Generated 12.Ara.2019 21:19:35 by Hibernate Tools 4.3.1

/**
 * Number generated by hbm2java
 */
public class Number implements java.io.Serializable {

    private Integer numberId;
    private Integer personId;
    private String number;

    public Number() {
    }

    public Number(Integer personId, String number) {
        this.personId = personId;
        this.number = number;
    }

    public Integer getNumberId() {
        return this.numberId;
    }

    public void setNumberId(Integer numberId) {
        this.numberId = numberId;
    }

    public Integer getPersonId() {
        return this.personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

}
