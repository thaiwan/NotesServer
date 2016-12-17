package ru.levelp.dao.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.levelp.dao.BaseServiceMongo;
import ru.levelp.entities.User;

import java.util.List;

/**
 * Created by Tanya on 06.12.2016.
 */
@Service("userServiceMongo")
public class UserServiceMongo extends BaseServiceMongo<User, String> implements UserDAO {


    @Autowired
    public UserServiceMongo(String mongoHost, String mongoDBName) {
        super(User.class, mongoHost, mongoDBName);
    }

    @Override
    public List<User> getAll() {
        return request().createQuery(User.class)
                .order("name")
                .asList();
    }

    @Override
    public List<User> get(List<String> ids) {
        return request().createQuery(User.class)
                .field("id").in(ids)
                .order("name")
                .asList();
    }

    @Override
    public User getByEmail(String email) {
        return request().createQuery(User.class)
                .field("email").equal(email)
                .get();
    }

    @Override
    public User getByToken(String token) {
        return request().createQuery(User.class)
                .field("token").equal(token)
                .get();
    }


}
