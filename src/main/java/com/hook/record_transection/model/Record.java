package com.hook.record_transection.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true)
    private int id;
    @Column(nullable = false,length = 100)
    private int status;
    @Column(nullable = false,length = 100)
    private float serviceAmount;
    @Column(nullable = false,length = 100)
    private Date created;
    @Column(nullable = true,length = 100)
    private float totalPrice;
     @ManyToOne
    private Category category;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public float getServiceAmount() {
        return this.serviceAmount;
    }

    public void setServiceAmount(float serviceAmount) {
        this.serviceAmount = serviceAmount;
    }

    public float getTotalPrice() {
        return this.totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getCreated() {
        return this.created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    
}