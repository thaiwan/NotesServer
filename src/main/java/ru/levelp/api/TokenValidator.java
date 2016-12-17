package ru.levelp.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.levelp.dao.user.UserDAO;
import ru.levelp.entities.User;
import ru.levelp.errors.TokenValidationException;

/**
 * Created by Tanya on 09.12.2016.
 */
@Component("tokenValidator")
public class TokenValidator {
    public static final String[] METHODS_TOKEN_NOT_REQUIRED = new String[] {
            Method.AUTHORIZE,
            Method.REGISTRATION
    };

    private UserDAO userServiceMongo;
@Autowired
    public TokenValidator(UserDAO userServiceMongo) {
        this.userServiceMongo = userServiceMongo;
    }

    public String validate(String method, String token) throws TokenValidationException {
        for (String m : METHODS_TOKEN_NOT_REQUIRED) {
            if (method.equals(m)) {
                break; //return null;
            }
        }
        if (token != null) {
            User user = userServiceMongo.getByToken(token);
            if (user != null){
                return user.getId();
            }
        }
        throw new TokenValidationException();
    }
}
