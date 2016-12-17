package ru.levelp.api;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.levelp.api.entities.BaseRequest;
import ru.levelp.api.entities.ResponseContainer;
import ru.levelp.errors.ProtocolValidationException;
import ru.levelp.errors.RequestExecutionError;
import ru.levelp.errors.TokenValidationException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * Created by Tanya on 09.12.2016.
 */
@Controller("wsHandler")
public class WSHandler extends WebSocketServer {
    private Gson gson;
    private ProtocolValidator protocolValidator;
    private TokenValidator tokenValidator;
    private RequestExecutor requestExecutor;

    @Autowired
    public WSHandler(Integer wsPort,
                     Gson gson,//должно быть соответствие как в бине
                     ProtocolValidator protocolValidator,
                     TokenValidator tokenValidator,
                     RequestExecutor requestExecutor) {
        super(new InetSocketAddress(wsPort));
        this.gson = gson;
        this.protocolValidator = protocolValidator;
        this.tokenValidator = tokenValidator;
        this.requestExecutor = requestExecutor;
    }

    @PostConstruct
    public void init() {
        start();
    }

    @PreDestroy
    public void destroy() {
        try {
            stop();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onOpen(WebSocket webSocket, ClientHandshake clientHandshake) {
        System.out.println("Client connected");
    }

    @Override
    public void onClose(WebSocket webSocket, int i, String s, boolean b) {
        System.out.println("Client disconnected");
    }

    @Override
    public void onMessage(WebSocket conn, String jsonRequest) {
//        System.out.println("message in thread: " + Thread.currentThread().getName());
        BaseRequest baseRequest = null;
        ResponseContainer response = null;
        try {
            baseRequest = gson.fromJson(jsonRequest, BaseRequest.class);
            protocolValidator.validate(baseRequest);
            String userId = tokenValidator.validate(baseRequest.getMethod(), baseRequest.getToken());
            response = requestExecutor.execute(jsonRequest, baseRequest.getMethod(), userId);
            response.setCode(200);
        } catch (JsonSyntaxException e) {
            response = new ResponseContainer<>(451, "JSON_PARSE_EXCEPTION");
        } catch (ProtocolValidationException e) {
            response = new ResponseContainer<>(452, "PROTOCOL_VALIDATION_EXCEPTION");
        } catch (TokenValidationException e) {
            response = new ResponseContainer<>(453, "INVALID_TOKEN");
        } catch (RequestExecutionError e) {
            response = new ResponseContainer<>(454, e.getMessage());
        }

        if (baseRequest != null) {
            response.setRequestId(baseRequest.getRequestId());
        }
        String answer = gson.toJson(response);
        conn.send(answer);
    }

    @Override
    public void onError(WebSocket webSocket, Exception e) {
        e.printStackTrace();
    }
}
