package ru.levelp.dao.user;

import org.hibernate.Session;
import ru.levelp.dao.BaseServiceHibernate;

/**
 * Created by Tanya on 08.12.2016.
 */
public class UserServiceHibernate {
    private Session session;

    public UserServiceHibernate() {
        this.session = BaseServiceHibernate.getInstance().getSession();
    }
}
