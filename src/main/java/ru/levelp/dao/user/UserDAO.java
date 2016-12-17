package ru.levelp.dao.user;

import ru.levelp.dao.BaseDAO;
import ru.levelp.entities.User;

import java.util.List;

/**
 * Created by Tanya on 06.12.2016.
 */
public interface UserDAO extends BaseDAO<User, String> {

    List<User> getAll();
    List<User> get(List<String> ids);
    User getByEmail(String email);
    User getByToken(String token);

}
