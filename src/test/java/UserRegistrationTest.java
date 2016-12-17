import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.levelp.AppConfig;
import ru.levelp.api.WSHandler;
import ru.levelp.dao.user.UserServiceMongo;
import ru.levelp.entities.User;

/**
 * Created by Tanya on 15.12.2016.
 */
public class UserRegistrationTest {

    @Test
    public void addTest() {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        WSHandler wsHandler = (WSHandler) context.getBean("wsHandler");
        wsHandler.onRequestReceived("");

        User user = new UserServiceMongo().getByEmail("");

        Assert.assertNotNull(user);
    }
}
