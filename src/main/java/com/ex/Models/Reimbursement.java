package com.ex.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Represents a reimbursement request. Has 3 statuses: pending, approved, denied.
 */
@Entity
@Table(name = "reimbursements_site")
public class Reimbursement implements Serializable {
    private static final long serialVersionUID = 2;

    public static final String PENDING = "Pending", APPROVED = "Approved", DENIED = "Denied";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "owner_id")
    private int owner_id;

    @Column(name = "purpose")
    private String purpose;

    @Column(name = "amount")
    private float amount ;

    @Column(name = "status")
    private String status;

    @Column(name = "manager_id")
    private int managerID;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOwnerID() {
        return owner_id;
    }

    public void setOwnerID(int ownerID) {
        this.owner_id = ownerID;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getManagerID() {
        return managerID;
    }

    public void setManagerID(int managerID) {
        this.managerID = managerID;
    }
}