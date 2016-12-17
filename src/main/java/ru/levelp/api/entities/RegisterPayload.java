package ru.levelp.api.entities;

/**
 * Created by Tanya on 15.12.2016.
 */
public class RegisterPayload {

    private String email;
    private String pwdHash;
    private String name;

    public String getEmail() {
        return email;
    }

    public String getPwdHash() {
        return pwdHash;
    }

    public String getName() {
        return name;
    }
}
