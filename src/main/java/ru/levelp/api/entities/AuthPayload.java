package ru.levelp.api.entities;

/**
 * Created by Tanya on 09.12.2016.
 */
public class AuthPayload {
    private String email;
    private String pwdHash;

    public String getEmail() {
        return email;
    }

    public String getPwdHash() {
        return pwdHash;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPwdHash(String pwdHash) {
        this.pwdHash = pwdHash;
    }
}
