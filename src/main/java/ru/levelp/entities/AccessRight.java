package ru.levelp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Tanya on 06.12.2016.
 */
@Entity
@Table(name = "access_rights")
public class AccessRight {
    @javax.persistence.Id
    @Column(name="id")
    private int id;
    @Column(name="mode")
    private int mode;
    @Column(name="userId")
    private String userId;

    private AccessRight() {
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public void setId(String id) {
        this.userId = id;
    }

    public int getMode() {
        return mode;
    }

    public String getId() {
        return userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setId(int id) {
        this.id = id;
    }
}


