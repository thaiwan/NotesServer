package ru.levelp.dao;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import ru.levelp.entities.BaseEntity;

/**
 * Created by Tanya on 06.12.2016.
 */
public abstract class BaseServiceMongo<E extends BaseEntity, ID> implements BaseDAO<E, ID> {
    private Datastore db;
    private Class<E> entityType;

    public BaseServiceMongo(Class<E> entityType, String host, String dbName) {
        this.entityType = entityType;

        Morphia morphia = new Morphia();
        db = morphia.createDatastore(
                new MongoClient(host), dbName);
        db.ensureIndexes();
    }

    public Datastore request() {
        return db;
    }

    public void add(E note) {
        db.save(note);
    }

    public void delete(E note) {
        db.delete(note);
    }

    public E get(ID id) {
        return db.get(entityType, id);
    }

    public void update(E note) {
        add(note);
    }
}
