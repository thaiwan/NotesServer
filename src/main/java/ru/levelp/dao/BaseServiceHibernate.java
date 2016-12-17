package ru.levelp.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Created by Tanya on 08.12.2016.
 */
public class BaseServiceHibernate {
    private SessionFactory sessionFactory = buildSessionFactory();
    private static BaseServiceHibernate instance;

    private BaseServiceHibernate() {

    }

    public static BaseServiceHibernate getInstance() {
        if (instance == null) {
            instance = new BaseServiceHibernate();
        }
        return instance;
    }

    private SessionFactory buildSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.configure();

        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).buildServiceRegistry();

        return configuration.buildSessionFactory(serviceRegistry);
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }



    public void close() {
        sessionFactory.close();
    }
}
