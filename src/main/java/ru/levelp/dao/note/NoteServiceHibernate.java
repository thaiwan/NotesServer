package ru.levelp.dao.note;

import org.hibernate.Session;
import ru.levelp.dao.BaseServiceHibernate;

/**
 * Created by Tanya on 08.12.2016.
 */
public class NoteServiceHibernate {
    private Session session;

    public NoteServiceHibernate() {
        this.session = BaseServiceHibernate.getInstance().getSession();
    }
}
