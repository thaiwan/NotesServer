package ru.levelp.dao.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.levelp.dao.user.UserDAO;

/**
 * Created by Tanya on 15.12.2016.
 */
@Controller("noteController")
public class NoteController {
    private UserDAO userService;

    @Autowired
    public NoteController(UserDAO userService) {//должен совпадать с id в spring
        this.userService = userService;
    }
}
