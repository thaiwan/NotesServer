package ru.levelp.api;

import org.springframework.stereotype.Component;
import ru.levelp.api.Method;
import ru.levelp.api.TokenValidator;
import ru.levelp.api.entities.BaseRequest;
import ru.levelp.errors.ProtocolValidationException;

/**
 * Created by Tanya on 09.12.2016.
 */
@Component("protocolValidator")
public class ProtocolValidator {

    public static final String[] METHODS = new String[] {
            Method.AUTHORIZE,
            Method.GET_NOTES,
            Method.REGISTRATION,
            Method.GET_USERS
    };


    public void validate(BaseRequest baseRequest) throws ProtocolValidationException {
        if (baseRequest.getRequestId() != null &&
                baseRequest.getMethod() != null) {
            for (String m : METHODS) {
                if (m.equals(baseRequest.getMethod())) {
                    return;
                }
            }
        }
        throw new ProtocolValidationException();
    }

}
