package ru.levelp.dao.note;

import org.mongodb.morphia.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.levelp.dao.BaseServiceMongo;
import ru.levelp.entities.Note;

import java.util.List;

/**
 * Created by Tanya on 06.12.2016.
 */
@Service("noteService")
public class NoteServiceMongo extends BaseServiceMongo<Note, String> implements NoteDAO {

    @Autowired
    public NoteServiceMongo(String mongoHost, String mongoDBName) {
        super(Note.class, mongoHost, mongoDBName);
    }

    public List<Note> getForUser(String id) {

        Query<Note> query = request().createQuery(Note.class);
        query.or(
                query.criteria("author").equal(id),
                query.criteria("accessRights.userId").equal(id)//затестить
        );
        return query
                .order("updated")
                .asList();
    }
}
