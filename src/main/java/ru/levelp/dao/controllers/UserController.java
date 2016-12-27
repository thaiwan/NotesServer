package ru.levelp.dao.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.levelp.api.entities.ResponseContainer;
import ru.levelp.dao.user.UserDAO;
import ru.levelp.dao.user.UserServiceMongo;
import ru.levelp.entities.User;
import ru.levelp.errors.RequestExecutionError;

import java.util.List;
import java.util.UUID;

/**
 * Created by Tanya on 09.12.2016.
 */
@Controller("userController")
public class UserController {

    private UserDAO userService;

    @Autowired
    public UserController(UserDAO userService) {//должен совпадать с id в spring
        this.userService = userService;
    }

    public ResponseContainer<String> authorize(String email, String pwdHash) throws RequestExecutionError {
        User user = userService.getByEmail(email);
        if (user != null && user.getPwdHash().equals(pwdHash)) {
            user.setToken(UUID.randomUUID().toString() + UUID.randomUUID().toString());
            userService.update(user);
            ResponseContainer<String> responseContainer = new ResponseContainer<String>(user.getToken());

            return responseContainer;
        }
        throw new RequestExecutionError("AUTHORIZE ERROR");
    }

    public ResponseContainer<String> register(String email, String pwdHash, String name) throws RequestExecutionError {
        User user = userService.getByEmail(email);
        if (user == null && email != null && pwdHash != null && name != null) {
            user.setId(UUID.randomUUID().toString() + UUID.randomUUID().toString());
            user.setToken(UUID.randomUUID().toString() + UUID.randomUUID().toString());
            user.setName(name);
            user.setEmail(email);
            user.setPwdHash(pwdHash);
            userService.add(user);

            ResponseContainer<String> responseContainer = new ResponseContainer<String>(user.getToken());

            return responseContainer;
        }

        throw new RequestExecutionError("REGISTRATION ERROR");
    }

    public ResponseContainer<List<User>> getUsers() {
        return new ResponseContainer<>(userService.getAll());
    }
}
