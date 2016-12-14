import com.lpc.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by liupengcheng1 on 2016/12/14.
 */
public class UserServiceTest extends BaseTest {

    @Autowired
    private UserService userService;

    @Test
    public void testHasMatchuser() {
        String userName = "root";
        String password = "root";
        boolean res = userService.hasMatchuser(userName, password);
        Assert.assertTrue(res);
    }

}
