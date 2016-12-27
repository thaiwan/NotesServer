package ru.levelp.dao.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.levelp.api.entities.ResponseContainer;
import ru.levelp.dao.note.NoteDAO;
import ru.levelp.entities.Note;

import java.util.List;

/**
 * Created by Tanya on 15.12.2016.
 */
@Controller("noteController")
public class NoteController {
    private NoteDAO noteService;

    @Autowired
    public NoteController(NoteDAO noteService) {//должен совпадать с id в spring
        this.noteService = noteService;
    }

    public ResponseContainer<List<Note>> getNotes(String userId) {
        return new ResponseContainer<>(noteService.getForUser(userId));
    }
}
