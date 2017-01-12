import com.lpc.other.aspect.one.Dog;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by liupengcheng1 on 2017/1/5.
 */
public class DogTest extends BaseTest {

    @Autowired
    private Dog dog;

    @Test
    public void testRun() {
        dog.run();
    }

}
