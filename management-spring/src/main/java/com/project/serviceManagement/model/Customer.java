package com.project.serviceManagement.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer cid;
    String fullName;

    @Column(unique = true)
    String phoneNumber;

    @OneToMany(fetch = FetchType.LAZY)
    Collection<Address> address = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY)
    Collection<ServiceOrder> orders = new ArrayList<>();

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Collection<Address> getAddress() {
        return address;
    }

    public void setAddress(Collection<Address> address) {
        this.address = address;
    }

    public Collection<ServiceOrder> getOrders() {
        return orders;
    }

    public void setOrders(Collection<ServiceOrder> orders) {
        this.orders = orders;
    }

    public Customer(Integer cid, String fullName, String phoneNumber, Collection<Address> address,
                    Collection<ServiceOrder> orders) {
        super();
        this.cid = cid;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.orders = orders;
    }

    public Customer() {
        super();
        // TODO Auto-generated constructor stub
    }


}
