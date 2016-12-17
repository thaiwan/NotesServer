package ru.levelp.dao.note;

import ru.levelp.dao.BaseDAO;
import ru.levelp.entities.Note;

import java.util.List;

/**
 * Created by Tanya on 06.12.2016.
 */
public interface NoteDAO extends BaseDAO<Note, String> {

    List<Note> getForUser(String id);

}
