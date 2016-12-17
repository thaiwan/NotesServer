package ru.levelp.dao.accessRight;

import org.hibernate.Session;
import ru.levelp.dao.BaseServiceHibernate;

/**
 * Created by Tanya on 08.12.2016.
 */
public class AccessRightHibernate {
    private Session session;

    public AccessRightHibernate() {
        this.session = BaseServiceHibernate.getInstance().getSession();
    }
}
