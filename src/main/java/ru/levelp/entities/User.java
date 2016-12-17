package ru.levelp.entities;

import com.google.gson.annotations.Expose;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import javax.persistence.Column;
import javax.persistence.Table;

@javax.persistence.Entity
@Table(name = "users")

/**
 * Created by Tanya on 06.12.2016.
 */
@Entity("users")
public class User implements BaseEntity<String> {
    @Id
    @javax.persistence.Id
    @Column(name="id")
    @Expose
    private String id;
    @Column(name="email")
    @Expose
    private String email;
    @Column(name="pwdHash")
    @Expose
    private String pwdHash;
    @Column(name="name")
    @Expose
    private String name;
    @Column(name="token")
    @Expose
    private String token;



    public User() {
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPwdHash(String pwdHash) {
        this.pwdHash = pwdHash;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getId() {

        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPwdHash() {
        return pwdHash;
    }

    public String getName() {
        return name;
    }

    public String getToken() {
        return token;
    }
}
