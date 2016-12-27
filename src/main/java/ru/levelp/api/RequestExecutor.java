package ru.levelp.api;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.levelp.api.entities.AuthPayload;
import ru.levelp.api.entities.RegisterPayload;
import ru.levelp.api.entities.RequestContainer;
import ru.levelp.api.entities.ResponseContainer;
import ru.levelp.dao.controllers.NoteController;
import ru.levelp.dao.controllers.UserController;
import ru.levelp.errors.RequestExecutionError;

/**
 * Created by Tanya on 09.12.2016.
 */
@Component("requestExecutor")
public class RequestExecutor {

    private Gson gson;
    private UserController userController;
    private NoteController noteController;

    @Autowired
    public RequestExecutor(Gson gson, UserController userController) {
        this.gson = gson;
        this.userController = userController;
    }

    public ResponseContainer execute(String json, String method, String userId)throws RequestExecutionError{
        switch (method) {

            case Method.AUTHORIZE:
                RequestContainer<AuthPayload> request =
                        gson.fromJson(json, new TypeToken<RequestContainer<AuthPayload>>() {
                        }.getType());
                return userController.authorize(request.getPayload().getEmail(),
                        request.getPayload().getPwdHash());



            case Method.REGISTRATION:
                RequestContainer<RegisterPayload> requestRegister =
                        gson.fromJson(json, new TypeToken<RequestContainer<RegisterPayload>>() {
                        }.getType());
                return userController.register(requestRegister.getPayload().getEmail(),
                        requestRegister.getPayload().getPwdHash(),
                        requestRegister.getPayload().getName());



            case Method.GET_NOTES:
                return noteController.getNotes(userId);

            case Method.GET_USERS:
                return userController.getUsers();


        }
        throw new RequestExecutionError(method + " ERROR");
    }
}
